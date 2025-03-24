package programmers.lv1

import java.util.PriorityQueue

fun solution(k: Int, score: IntArray): IntArray {
    val answer = ArrayList<Int>()
    val pq = PriorityQueue<Int>()
    score.forEach { s ->
        pq.add(s)
        if (pq.size > k) pq.poll()
        answer.add(pq.peek())
    }
    return answer.toIntArray()
}