package baekjoon.gold.g2.문제집

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nm = br.readLine().split(" ")
    val n = nm[0].toInt() // 문제의 수
    val m = nm[1].toInt() // 먼저 푸는게 좋은 문제의 수

    val inDegree = Array(n + 1) { 0 }
    val problem = Array(n + 1) { ArrayList<Int>() }
    val result = ArrayList<Int>()

    repeat(m) {
        val line = br.readLine().split(" ")
        // 4 2 - 4번은 2번보다 먼저, a는 b보다 먼저
        val a = line[0].toInt()
        val b = line[1].toInt()

        inDegree[b]++
        problem[a].add(b)
    }

    val q = PriorityQueue<Int>()

    for (i in 1..n) {
        if (inDegree[i] == 0) q.offer(i)
    }

    for(i in 1 .. n) {
        val target = q.poll()
        result.add(target)

        for(j in 0 until problem[target].size) {
            val target2 = problem[target][j]
            if(--inDegree[target2] == 0) {
                q.offer(target2)
            }
        }
    }

    result.forEach { print("$it ") }
}

/*
4 2
4 2
3 1
 */