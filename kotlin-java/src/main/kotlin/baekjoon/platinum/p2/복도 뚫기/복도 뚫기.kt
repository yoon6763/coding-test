package baekjoon.platinum.p2.`복도 뚫기`

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

class Edge(var from: Int, var to: Int, var weight: Double)
class Circle(var x: Double, var y: Double, var r: Double)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val (w, n) = List(2) { readLine().toInt() }
        val circles = Array(n) {
            val st = StringTokenizer(readLine())
            Circle(st.nextToken().toDouble(), st.nextToken().toDouble(), st.nextToken().toDouble())
        }

        parent = IntArray(n + 2) { it }

        val pq = PriorityQueue<Edge>(compareBy { it.weight })
        pq.add(Edge(n, n + 1, w.toDouble()))

        for (i in 0..<n) {
            var dist = (circles[i].x - circles[i].r)
            pq.add(Edge(n, i, dist))

            dist = (w - circles[i].x - circles[i].r)
            pq.add(Edge(i, n + 1, dist))

            for (j in i + 1..<n) {
                dist = getDistance(circles[i], circles[j])
                pq.add(Edge(i, j, dist))
            }
        }

        while (pq.isNotEmpty()) {
            val cur = pq.poll()

            if (union(cur.from, cur.to)) {
                if (find(n) == find(n + 1)) {
                    sb.appendLine(if (cur.weight <= 0) 0 else String.format("%.6f", cur.weight / 2))
                    break
                }
            }
        }
    }

    print(sb)
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = arrayOf(find(x), find(y))
    if (px == py) return false
    parent[py] = px
    return true
}

fun getDistance(c1: Circle, c2: Circle) = sqrt((c2.x - c1.x).pow(2) + (c2.y - c1.y).pow(2.0)) - c1.r - c2.r