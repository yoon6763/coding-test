package baekjoon.gold.g1.이사

import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val nodes = Array(n) {
        val st = StringTokenizer(readLine())
        Node(st.nextToken().toInt(), st.nextToken().toInt())
    }

    var min = Double.MAX_VALUE
    var idx = -1

    for (i in 0 until n) {
        var nowMaxDistance = -1.0

        for (j in 0 until n) {
            val distance = sqrt(
                (nodes[i].x - nodes[j].x).toDouble().pow(2) +
                        (nodes[i].y - nodes[j].y).toDouble().pow(2)
            )

            nowMaxDistance = maxOf(nowMaxDistance, distance)
        }

        if (min > nowMaxDistance) {
            min = nowMaxDistance
            idx = i
        }
    }

    println("${nodes[idx].x} ${nodes[idx].y}")
}