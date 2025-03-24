package baekjoon.gold.g3.`무엇을 아느냐가 아니라 누구를 아느냐가 문제다`

import java.util.PriorityQueue
import java.util.Stack
import java.util.StringTokenizer

data class Node(val to: Int, val weight: Int)

fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()
    val MAX = 987654321

    repeat(readLine().toInt()) {
        val nm = StringTokenizer(readLine())
        val n = nm.nextToken().toInt() // 관계의 수
        val m = nm.nextToken().toInt() // 사람의 수

        val connect = Array(m) { ArrayList<Node>() }
        repeat(n) {
            val st = StringTokenizer(readLine())
            val (from, to, weight) = List(3) { st.nextToken().toInt() }
            connect[from].add(Node(to, weight))
            connect[to].add(Node(from, weight))
        }

        val distance = IntArray(m) { MAX }
        val pre = IntArray(m) { -1 }

        distance[0] = 0

        val pq = PriorityQueue<Node>(compareBy { it.weight })
        pq.offer(Node(0, 0))

        while (pq.isNotEmpty()) {
            val cur = pq.poll()

            if (cur.weight > distance[cur.to]) continue

            connect[cur.to].forEach { next ->
                if (distance[cur.to] + next.weight >= distance[next.to]) return@forEach

                distance[next.to] = distance[cur.to] + next.weight
                pq.offer(Node(next.to, distance[next.to]))
                pre[next.to] = cur.to
            }
        }

        sb.append("Case #${it + 1}: ")

        if (distance[m - 1] == MAX) {
            sb.append(-1).append("\n")
            return@repeat
        }

        val tracking = Stack<Int>()

        var cur = m - 1
        while (cur != -1) {
            tracking.add(cur)
            cur = pre[cur]
        }

        while (tracking.isNotEmpty()) {
            sb.append(tracking.pop()).append(" ")
        }
        sb.append("\n")
    }
    print(sb)
}