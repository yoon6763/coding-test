package baekjoon.platinum.p4.K번째최단경로찾기

import java.util.*

data class Node(val to: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.weight - other.weight
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val connection = Array(n + 1) { ArrayList<Node>() }

    repeat(m) {
        val st = StringTokenizer(readLine())
        connection[st.nextToken().toInt()].add(Node(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    val answerPQ = dijkstra(n, k, connection, 1)
    val sb = StringBuilder()

    for (i in 1..n) {
        if (answerPQ[i].size == k) {
            sb.append(answerPQ[i].poll())
        } else {
            sb.append("-1")
        }

        sb.append("\n")
    }

    print(sb)
}

fun dijkstra(n: Int, k: Int, connection: Array<ArrayList<Node>>, startNode: Int): Array<PriorityQueue<Int>> {
    val pq = PriorityQueue<Node>()
    pq.offer(Node(startNode, 0))

    val answerPQ = Array(n + 1) { PriorityQueue<Int>(Collections.reverseOrder()) }
    answerPQ[1].add(0)

    while (pq.isNotEmpty()) {
        val target = pq.poll()

        connection[target.to].forEach { nextNode ->
            val newWeight = nextNode.weight + target.weight

            if (answerPQ[nextNode.to].size < k) {
                answerPQ[nextNode.to].add(newWeight)
                pq.add(Node(nextNode.to, newWeight))
            } else if (answerPQ[nextNode.to].peek() > newWeight) {
                answerPQ[nextNode.to].poll()
                answerPQ[nextNode.to].add(newWeight)
                pq.offer(Node(nextNode.to, newWeight))
            }
        }
    }

    return answerPQ
}