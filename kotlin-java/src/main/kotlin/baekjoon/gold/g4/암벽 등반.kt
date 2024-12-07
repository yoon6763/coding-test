package baekjoon.gold.g4

import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(System.`in`.bufferedReader()) {
    data class Node(val x: Int, val y: Int)

    val (n, t) = readLine().split(" ").map { it.toInt() }
    val points = Array(t + 1) { ArrayList<Int>() }

    for (i in 0..<n) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        points[y].add(x)
    }

    points.forEach { it.sort() }

    val q = ArrayDeque<Node>()
    q.add(Node(0, 0))

    var ans = 0

    while (q.isNotEmpty()) {
        for (i in 0..<q.size) {
            val (x, y) = q.removeFirst()

            for (ny in y - 2..y + 2) {
                if (ny !in 0..t) continue

                var xPtr = 0
                while (xPtr < points[ny].size) {
                    if (x + 2 < points[ny][xPtr]) break
                    if (x - 2 > points[ny][xPtr]) {
                        xPtr++
                        continue
                    }

                    q.add(Node(points[ny][xPtr], ny))
                    points[ny].removeAt(xPtr)

                    if (ny == t) {
                        println(ans + 1)
                        return
                    }
                }
            }
        }

        ans++
    }

    println(-1)
}