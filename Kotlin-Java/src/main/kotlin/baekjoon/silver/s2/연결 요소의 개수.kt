package baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt() // 정점의 개수
    val m = nm[1].toInt() // 간선의 개수

    val map = Array(n) { Array(n) { false } }
    var block = 0

    repeat(m) {
        val input = br.readLine().split(" ")
        val n1 = input[0].toInt() - 1
        val n2 = input[1].toInt() - 1

        map[n1][n2] = true
        map[n2][n1] = true
    }

    val visited = Array(n) { false }

    for (i in 0 until n) {
        if (visited[i]) continue

        val q = LinkedList<Int>() as Queue<Int>

        q.offer(i)
        visited[i] = true

        while (q.isNotEmpty()) {
            val target = q.poll()

            for (j in 0 until n) {
                if (map[target][j] && !visited[j]) {
                    visited[j] = true
                    q.offer(j)
                }
            }
        }
        block++
    }
    println(block)
}