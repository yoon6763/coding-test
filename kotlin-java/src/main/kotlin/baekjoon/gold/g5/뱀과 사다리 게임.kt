package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val visited = Array(101) { 0 }
    val next = Array(101) { -1 } // -1 이면 제자리
    val nm = br.readLine().split(" ") // 사다리, 뱀

    repeat(nm[0].toInt() + nm[1].toInt()) {
        val line = br.readLine().split(" ")
        next[line[0].toInt()] = line[1].toInt()
    }


    val q = LinkedList<Int>() as Queue<Int>

    q.offer(1)
    visited[1] = 1

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 1..6) {
            var nTarget = target + i

            if (nTarget <= 100 && next[nTarget] != -1) {
                nTarget = next[nTarget]
            }

            if (nTarget > 100 || visited[nTarget] != 0) continue

            visited[nTarget] = visited[target] + 1
            q.offer(nTarget)

            if (nTarget == 100) {
                println(visited[nTarget] - 1)
                break
            }
        }
    }
}