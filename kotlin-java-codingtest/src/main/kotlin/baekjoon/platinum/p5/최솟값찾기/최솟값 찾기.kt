package baekjoon.platinum.p5.최솟값찾기

import java.util.*

class Node(val value: Int, val index: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())
    val sb = StringBuilder()

    val deque = LinkedList<Node>() as Deque<Node>

    repeat(n) {
        val num = st.nextToken().toInt()

        while (deque.isNotEmpty() && deque.last.value > num) {
            deque.removeLast()
        }

        deque.addLast(Node(num, it))

        if (deque.first.index <= it - l) deque.removeFirst()
        sb.append(deque.first.value).append(" ")
    }

    print(sb)
}