package baekjoon.bronze.b1

import java.lang.StringBuilder
import kotlin.math.roundToInt

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n) {
        val arr = readLine().split(" ").map { it.toInt() }
        val avg = (arr.sum() - arr[0]) / arr[0]
        var count = 0
        for (i in 1..arr[0]) {
            if (arr[i] > avg) count++
        }

        sb.append("${String.format("%.3f", (count.toDouble() / arr[0] * 100000.0).roundToInt() / 1000.0)}%\n")
    }
    print(sb)
}