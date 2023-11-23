package baekjoon.gold.g3.우주신과의교감

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt


data class Point(var x: Long, var y: Long)
data class Edge(var from: Int, var to: Int, var weight: Double) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return if (this.weight > other.weight) 1 else -1
    }
}

lateinit var parent: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val pq = PriorityQueue<Edge>()
    val points = Array<Point?>(n + 1) { null }
    parent = Array(n + 1) { it }

    // 각 점들
    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        points[i] = Point(st.nextToken().toLong(), st.nextToken().toLong())
    }

    // 이미 연결된 점들
    repeat(m) {
        val st = StringTokenizer(readLine())
        union(st.nextToken().toInt(), st.nextToken().toInt())
    }

    // 모든 정점을 서로 연결
    for (i in 1..n) {
        for (j in i + 1..n) {
            // 두 점들의 거리는 좌표평면에서 두 점 구하는 방법과 같음
            val weight = sqrt(
                (points[i]!!.x - points[j]!!.x).toDouble().pow(2) +
                        (points[i]!!.y - points[j]!!.y).toDouble().pow(2)
            )
            pq.offer(Edge(i, j, weight))
        }
    }

    var total = 0.0

    while (pq.isNotEmpty()) {
        val target = pq.poll()

        if (find(target.from) != find(target.to)) {
            total += target.weight
            union(target.from, target.to)
        }
    }

    println(String.format("%.2f", total))
}


fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        return parent[x]
    }
}

fun union(x: Int, y: Int) {
    val nx = find(x)
    val ny = find(y)

    if (nx != ny) {
        parent[nx] = ny
    }
}