package baekjoon.gold.g5

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val btn = IntArray(5)
        var hour = n / 60
        var tenMin = (n % 60) / 10
        var oneMin = n % 10

        if (oneMin > 5) {
            tenMin += 1
            oneMin -= 10
        }
        if (tenMin > 3) {
            hour += 1
            tenMin -= 6
        }
        if (tenMin < 0 && oneMin == 5) {
            tenMin += 1
            oneMin -= 10
        }

        btn[0] = hour
        if (tenMin >= 0) btn[1] = tenMin
        else btn[2] = abs(tenMin)

        if (oneMin >= 0) btn[3] = oneMin
        else btn[4] = abs(oneMin)

        sb.appendLine(btn.joinToString(" "))
    }
    print(sb)
}
