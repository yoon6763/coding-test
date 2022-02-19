class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = IntArray(id_list.size) { 0 }
        var newReport = report.distinct()

        val notifier = Array(newReport.size) { "" }
        val notified = Array(newReport.size) { "" }

        var warningCnt = IntArray(id_list.size) { 0 }

        for (i in newReport.indices) {
            notifier[i] = newReport[i].trim().split(" ")[0]
            notified[i] = newReport[i].trim().split(" ")[1]
        }

        // 신고 당한 횟수
        for (i in newReport.indices) warningCnt[id_list.indexOf(notified[i])]++

        for (i in notified.indices) {
            if (warningCnt[id_list.indexOf(notified[i])] >= k) {
                answer[id_list.indexOf(notifier[i])]++
            }
        }

        return answer
    }
}

fun main() {
    var sol = Solution()
    var id_list = arrayOf("con", "ryan")
    var report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
    val k = 2

    print(sol.solution(id_list, report, k).forEach { println(it) })
}