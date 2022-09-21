package baekjoon.gold.g3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import kotlin.math.sign

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nm = br.readLine().split(" ")
    val n = nm[0].toInt() // 가수의 수
    val m = nm[1].toInt() // PD의 수
    val result = ArrayList<Int>()

    val inDegree = Array(n + 1) { 0 }
    val connectedNode = Array(n + 1) { ArrayList<Int>() }

    for (i in 1..m) {
        val line = br.readLine().split(" ").map { it.toInt() }

        for (j in 2..line[0]) {
            inDegree[line[j]]++
            connectedNode[line[j - 1]].add(line[j])
        }
    }

    val q: Queue<Int> = LinkedList()

    repeat(n) { if (inDegree[it + 1] == 0) q.offer(it + 1) }

    for (i in 1..n) {
        if (q.isEmpty()) {
            println("0") // 큐가 빔. 사이클 발생...
            return
        }

        val target = q.poll()
        result.add(target)

        for (j in 0 until connectedNode[target].size) {
            val y = connectedNode[target][j]
            if (--inDegree[y] == 0) {
                q.offer(y)
            }
        }
    }

    result.forEach {
        println(it)
    }
}