package baekjoon.bronze.b1

import kotlin.math.roundToInt

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        var total = 0.0
        var miss = 0.0

        while (true) {
            val str = readln()
            if (str.isEmpty()) break

            total += str.length
            miss += str.count { it == '#' }
        }

        val ratio = ((100.0 - ((miss / total) * 100.0)) * 10).roundToInt().toDouble() / 10
        val ratioIsInt = ratio - ratio.toInt() == 0.0
        sb.appendLine("Efficiency ratio is ${if (ratioIsInt) ratio.toInt() else ratio}%.")
    }

    print(sb)
}