package baekjoon.gold.g3.`최소비용 구하기 2`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

private data class Node(var to: Int, var weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.weight - other.weight
    }
}

private val MAX_VALUE = 100000000
private lateinit var weight: Array<ArrayList<Node>>
private lateinit var distance: Array<Int>
private lateinit var preNode: Array<Int>
private var n = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt() // 도시 개수
    val m = br.readLine().toInt() // 버스 개수

    distance = Array(n + 1) { MAX_VALUE }
    preNode = Array(n + 1) { 0 }
    weight = Array(n + 1) { ArrayList() }

    repeat(m) {
        val st = StringTokenizer(br.readLine())
        weight[st.nextToken().toInt()].add(Node(st.nextToken().toInt(),st.nextToken().toInt()))
    }

    val st = StringTokenizer(br.readLine())
    val start = st.nextToken().toInt()
    var end = st.nextToken().toInt()

    dijkstra(start)
    println(distance[end])

    val stack = Stack<Int>()
    var cnt = 0
    stack.push(end)

    while (preNode[end] != 0) {
        cnt++
        stack.push(preNode[end])
        end = preNode[end]
    }

    println(cnt + 1)

    while (stack.isNotEmpty()) {
        print("${stack.pop()} ")
    }

}

private fun dijkstra(start: Int) {
    distance[start] = 0

    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))

    while (pq.isNotEmpty()) {
        val target = pq.poll()
        val targetPoint = target.to

        if (distance[targetPoint] < target.weight) continue

        weight[targetPoint].forEach { nextNode ->
            if (distance[nextNode.to] > distance[targetPoint] + nextNode.weight) {
                distance[nextNode.to] = distance[targetPoint] + nextNode.weight
                preNode[nextNode.to] = targetPoint
                pq.offer(Node(nextNode.to, distance[nextNode.to]))
            }
        }
    }
}