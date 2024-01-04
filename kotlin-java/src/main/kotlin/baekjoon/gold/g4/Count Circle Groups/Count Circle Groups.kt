package baekjoon.gold.g4.`Count Circle Groups`

import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

data class Circle(val x: Int, val y: Int, val r: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val circles = Array(n) {
            val st = StringTokenizer(readLine())
            Circle(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        }

        parent = IntArray(n) { it }

        for (i in 0..<n) {
            for (j in i + 1..<n) {
                if (isConnected(circles[i], circles[j])) union(i, j)
            }
        }

        val parentSet = HashSet<Int>()
        for (i in 0..<n) {
            parentSet.add(find(i))
        }

        sb.appendLine(parentSet.size)
    }

    print(sb)
}

fun isConnected(circle1: Circle, circle2: Circle): Boolean {
    val (x1, y1, r1) = circle1
    val (x2, y2, r2) = circle2

    val d = sqrt((x1 - x2).toDouble().pow(2.0) + (y1 - y2).toDouble().pow(2.0))

    return d <= r1 + r2
}


fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)
    parent[py] = px
}