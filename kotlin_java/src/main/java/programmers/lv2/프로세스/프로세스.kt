package programmers.lv2.프로세스

import java.util.*

fun solution(priorities: IntArray, location: Int): Int {
    val priorityQueue = PriorityQueue(Collections.reverseOrder<Int>())
    var answer = 0

    for (element in priorities) priorityQueue.add(element)

    while (!priorityQueue.isEmpty()) {
        for (i in priorities.indices) {
            if (priorities[i] === priorityQueue.peek()) {
                if (i == location) {
                    answer++
                    return answer
                }
                priorityQueue.poll()
                answer++
            }
        }
    }
    return -1
}