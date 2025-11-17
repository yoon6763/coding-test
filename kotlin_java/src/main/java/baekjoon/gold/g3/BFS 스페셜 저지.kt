package baekjoon.gold.g3

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val connected = Array(n + 1) { ArrayList<Int>() }

    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = Array(2) { st.nextToken().toInt() }
        connected[v1].add(v2)
        connected[v2].add(v1)
    }


    val st = StringTokenizer(readLine())
    val answer = Array(n) { st.nextToken().toInt() }
    val visited = Array(n + 1) { false }

    if (answer[0] != 1) {
        println(0)
        return@with
    }

    val q = LinkedList<Int>() as Queue<Int>
    q.offer(1)
    visited[1] = true
    var pathIdx = 1

    while (q.isNotEmpty()) {
        val target = q.poll()

        val set = HashSet<Int>()

        connected[target].forEach { next ->
            if (visited[next]) return@forEach
            visited[next] = true
            set.add(next)
        }

        repeat(set.size) {
            if (answer[pathIdx + it] in set) {
                q.offer(answer[pathIdx + it])
            } else {
                println(0)
                return@with
            }
        }
        pathIdx += set.size
    }

    println(1)
}