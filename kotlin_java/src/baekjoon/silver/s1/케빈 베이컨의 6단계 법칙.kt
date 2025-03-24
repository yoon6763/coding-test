package baekjoon.silver.s1.케빈베이컨의6단계법칙

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ") // 사람의 수, 간선의 갯수
    val n = nm[0].toInt() // 사람의 수
    val m = nm[1].toInt() // 간선의 갯수

    val connection = Array(n + 1) { Array(n + 1) { false } }

    repeat(m) {
        val line = br.readLine().split(" ")
        val p1 = line[0].toInt()
        val p2 = line[1].toInt()

        connection[p1][p2] = true
        connection[p2][p1] = true
    }

    val kevin = ArrayList<Int>()

    for (i in 1..n) {
        val visited = Array(n + 1) { -1 }

        val queue: Queue<Int> = LinkedList()
        visited[i] = 0
        queue.offer(i)

        while (queue.isNotEmpty()) {
            val target = queue.poll()

            for (j in 1..n) {
                if (connection[target][j] && visited[j] == -1) {
                    visited[j] = visited[target] + 1
                    queue.offer(j)
                }
            }
        }
        var sum = 0
        visited.forEach {
            if (it != -1) sum += it
        }

        kevin.add(sum)
    }
    println(kevin.indexOf(kevin.minOrNull()!!) + 1)
}