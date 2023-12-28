package baekjoon.silver.s1.`Small World Network`

import java.util.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val connect = Array(n) { ArrayList<Int>() }

    repeat(k) {
        val (f1, f2) = readLine().split(" ").map { it.toInt() - 1 }
        connect[f1].add(f2)
        connect[f2].add(f1)
    }

    repeat(n) {
        val visited = Array(n) { -1 }
        val queue = ArrayDeque<Int>()
        queue.add(it)
        visited[it] = 0

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()

            connect[cur].forEach { next ->
                if (visited[next] != -1) return@forEach
                visited[next] = visited[cur] + 1
                queue.add(next)

                if (visited[next] == 7) {
                    println("Big World!")
                    return@with
                }
            }
        }

        if (visited.any { it == -1 }) {
            println("Big World!")
            return@with
        }
    }

    println("Small World!")
}