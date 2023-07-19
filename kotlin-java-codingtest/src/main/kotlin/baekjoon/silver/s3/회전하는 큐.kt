package baekjoon.silver.s3

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val deque = ArrayDeque<Int>()

    repeat(n) {
        deque.addLast(it + 1)
    }

    val st = StringTokenizer(readLine())

    var cnt = 0

    while (st.hasMoreTokens()) {
        val target = st.nextToken().toInt()
        val targetIdx = deque.indexOf(target)

        val halfSize = if (deque.size % 2 == 0) deque.size / 2 - 1 else deque.size / 2

        if (targetIdx > halfSize) {
            repeat(deque.size - targetIdx) {
                cnt++
                deque.addFirst(deque.removeLast())
            }
        } else {
            repeat(targetIdx) {
                cnt++
                deque.addLast(deque.removeFirst())
            }
        }

        deque.removeFirst()
    }
    println(cnt)
}