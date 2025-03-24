package programmers.lv3.`디스크 컨트롤러`

import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        jobs.sortBy { it[0] }

        val n = jobs.size
        val pq = PriorityQueue<IntArray>(compareBy{it[1]})
        var answer = 0
        var jobIndex = 0
        var finished = 0
        var end = 0

        while(finished < n) {
            while(jobIndex < n && jobs[jobIndex][0] <= end) {
                pq.offer(jobs[jobIndex++])
            }

            if(pq.isEmpty()) {
                end = jobs[jobIndex][0];
            } else {
                val cur = pq.poll()
                answer += cur[1] + end - cur[0]
                end += cur[1]
                finished++
            }
        }

        return answer / n
    }
}