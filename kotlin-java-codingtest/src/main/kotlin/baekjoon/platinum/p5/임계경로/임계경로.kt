package baekjoon.platinum.p5.임계경로

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Node(val to: Int, val time: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt() // 도시 개수
    val m = readLine().toInt() // 도로 개수

    val connection = Array(n + 1) { ArrayList<Node>() }
    val reversed = Array(n + 1) { ArrayList<Node>() }
    val inDegree = Array(n + 1) { 0 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (from, to, weight) = Array(3) { st.nextToken().toInt() }
        connection[from].add(Node(to, weight))
        reversed[to].add(Node(from, weight))
        inDegree[to]++
    }

    val st = StringTokenizer(readLine())
    val (startCity, endCity) = Array(2) { st.nextToken().toInt() }


    // 위상정렬
    var q = LinkedList<Int>() as Queue<Int>
    q.offer(startCity)
    val result = Array(n + 1) { 0 }

    while (q.isNotEmpty()) {
        val now = q.poll()
        connection[now].forEach { nextNode ->
            inDegree[nextNode.to]--
            result[nextNode.to] = maxOf(result[nextNode.to], result[now] + nextNode.time)

            if (inDegree[nextNode.to] == 0) q.offer(nextNode.to)
        }
    }

    // 위상정렬 반대
    var resultCnt = 0
    val visited = Array(n + 1) { false }
    q = LinkedList<Int>() as Queue<Int>
    q.offer(endCity)
    visited[endCity] = true

    while (q.isNotEmpty()) {
        val now = q.poll()
        reversed[now].forEach { nextNode ->
            if (result[nextNode.to] + nextNode.time == result[now]) {
                resultCnt++

                if (!visited[nextNode.to]) {
                    visited[nextNode.to] = true
                    q.offer(nextNode.to)
                }
            }
        }
    }

    println(result[endCity])
    println(resultCnt)
}