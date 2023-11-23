package baekjoon.silver.s1

import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val connection = Array(n + 1) { ArrayList<Int>() }
    val result = Array(n + 1) { 0 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        connection[st.nextToken().toInt()].add(st.nextToken().toInt())
    }

    for (i in 1..n) {
        val visited = Array(n + 1) { false }
        visited[i] = true

        val q = LinkedList<Int>() as Queue<Int>
        q.offer(i)

        while (q.isNotEmpty()) {
            val target = q.poll()

            connection[target].forEach { nextNode ->
                if (!visited[nextNode]) {
                    visited[nextNode] = true
                    q.offer(nextNode)
                    result[nextNode]++
                }
            }
        }
    }

    val max = result.maxOrNull()!!
    val sb = StringBuilder()

    result.forEachIndexed { index, value ->
        if(value == max) sb.append(index).append(" ")
    }
    println(sb)
}