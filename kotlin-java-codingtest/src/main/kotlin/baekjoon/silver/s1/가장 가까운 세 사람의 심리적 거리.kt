package baekjoon.silver.s1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().trim().toInt()) {
        val n = readLine().toInt()
        val st = StringTokenizer(readLine())

        if (n > 32) {
            sb.appendLine("0")
            return@repeat
        }

        val mbti = Array(n) { st.nextToken() }
        var min = Int.MAX_VALUE

        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                for (k in j + 1 until n) {
                    var distance = 0

                    for (l in 0 until 4) {
                        if (mbti[i][l] != mbti[j][l]) distance++
                        if (mbti[j][l] != mbti[k][l]) distance++
                        if (mbti[k][l] != mbti[i][l]) distance++
                    }

                    min = min.coerceAtMost(distance)

                    if (min == 0) {
                        sb.appendLine("0")
                        return@repeat
                    }
                }
            }
        }
        sb.appendLine(min)
    }
    print(sb)
}