import java.util.*


fun main() {
    val solution3 = Solution3()
    print(solution3.solution(intArrayOf(2, 1, 3, 2), 2))
}

class Solution3 {
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
}