package baekjoon.gold.g5.물통

import java.util.HashSet
import java.util.LinkedList
import java.util.Queue

data class Bottle(val a: Int, val b: Int, val c: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val capacity = readLine().split(" ").map { it.toInt() }.toTypedArray()

    // a, b는 빔, c는 가득 참
    val visited = Array(capacity[0] + 1) { Array(capacity[1] + 1) { Array(capacity[2] + 1) { false } } }
    val answer = HashSet<Int>()

    val q = LinkedList<Bottle>() as Queue<Bottle>
    q.offer(Bottle(0, 0, capacity[2]))

    while (q.isNotEmpty()) {
        val (a, b, c) = q.poll()

        if (visited[a][b][c]) continue
        visited[a][b][c] = true

        if (a == 0) {
            answer.add(c)
        }

        // a -> b
        if (a + b > capacity[1]) {
            q.offer(Bottle(a + b - capacity[1], capacity[1], c))
        } else {
            q.offer(Bottle(0, a + b, c))
        }

        // a -> c
        if (a + c > capacity[2]) {
            q.offer(Bottle(a + c - capacity[2], b, capacity[2]))
        } else {
            q.offer(Bottle(0, b, a + c))
        }

        // b -> a
        if (a + b > capacity[0]) {
            q.offer(Bottle(capacity[0], a + b - capacity[0], c))
        } else {
            q.offer(Bottle(a + b, 0, c))
        }

        // b -> c
        if (b + c > capacity[2]) {
            q.offer(Bottle(a, b + c - capacity[2], capacity[2]))
        } else {
            q.offer(Bottle(a, 0, b + c))
        }

        // c -> a
        if (a + c > capacity[0]) {
            q.offer(Bottle(capacity[0], b, a + c - capacity[0]))
        } else {
            q.offer(Bottle(a + c, b, 0))
        }

        // c -> b
        if (b + c > capacity[1]) {
            q.offer(Bottle(a, capacity[1], b + c - capacity[1]))
        } else {
            q.offer(Bottle(a, b + c, 0))
        }
    }
    println(answer.sorted().joinToString(" "))
}
