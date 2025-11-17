package programmers.lv3.`입국심사`

class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var right = 1000000000L * 1000000000L
        var left = 1L
        var answer = right

        while (left <= right) {
            val mid = (left + right) / 2

            var count = times.sumOf { mid / it.toLong() }

            if (count >= n) {
                right = mid - 1
                answer = mid
            } else {
                left = mid + 1
            }
        }

        return answer
    }
}