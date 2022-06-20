class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val result = ArrayList<Int>()
        var dis = 0
        var cnt = 0

        while (true) {
            for (i in dis until progresses.size) {
                progresses[i] += speeds[i]
                if (progresses[i] >= 100) {
                    dis++
                    cnt++
                    for (j in i until progresses.size) {
                        if (progresses[j] >= 100) {
                            dis++
                            cnt++
                        } else {
                            result.add(cnt)
                            cnt = 0
                            break
                        }
                    }
                }
            }
            if(dis > progresses.size) break
        }

        result.forEach { println(it) }

        return result.toIntArray()
    }
}


fun main() {
    val sol = Solution()
    sol.solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
}