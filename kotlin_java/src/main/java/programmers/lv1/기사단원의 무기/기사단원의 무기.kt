package programmers.lv1.`기사단원의 무기`

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer = 0

        for (i in 1..number) {
            var count = 0
            var j = 1

            while (j * j <= i) {
                if (j * j == i) {
                    count++
                } else if (i % j == 0) {
                    count += 2
                }
                j++
                if (count > limit) break
            }
            answer += if (count > limit) power else count
        }

        return answer
    }
}