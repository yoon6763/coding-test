package baekjoon.gold.g3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt() // 학생의 수
    val m = nm[1].toInt() // 간선의 수
    val inDegree = Array(n + 1) { 0 }

    val student = Array(n + 1) { ArrayList<Int>() }
    val result = ArrayList<Int>()

    repeat(m) {
        val line = br.readLine().split(" ").map { it.toInt() } // 앞에 나온게 큼
        student[line[0]].add(line[1])
        inDegree[line[1]]++
    }

    val q = LinkedList<Int>() as Queue<Int>

    for(i in 1 .. n) {
        if(inDegree[i] == 0) q.offer(i)
    }

    for(i in 1 .. n) {
        val target = q.poll()
        result.add(target)

        for(j in 0 until student[target].size) {
            val target2 = student[target][j]
            inDegree[target2]--
            if(inDegree[target2] == 0) q.offer(target2)
        }
    }
    result.forEach { print("$it ") }
}