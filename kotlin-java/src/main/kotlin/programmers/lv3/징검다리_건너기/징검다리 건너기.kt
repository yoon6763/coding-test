package programmers.lv3.징검다리_건너기

import kotlin.collections.ArrayDeque

data class Node(val idx: Int, val value: Int)

fun solution(stones: IntArray, k: Int): Int {

    var answer = Int.MAX_VALUE

    val deque = ArrayDeque<Node>()

    stones.forEachIndexed { index, i ->
        while (deque.isNotEmpty() && deque.last().value <= i) deque.removeLast()

        deque.addLast(Node(index, i))

        if (index >= k - 1) {
            while (deque.isNotEmpty() && deque.first().idx <= index - k) deque.removeFirst()
            answer = answer.coerceAtMost(deque.first().value)
        }
    }

    return answer
}