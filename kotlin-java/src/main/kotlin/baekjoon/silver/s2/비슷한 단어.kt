package baekjoon.silver.s2

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val count = Array(26) { 0 }
    val str = readLine()
    str.forEach { count[it - 'A'] += 1 }

    var ans = 0

    repeat(n - 1) {
        val newCount = Array(26) { 0 }
        val newStr = readLine()
        if (abs(str.length - newStr.length) > 1 || str == newStr) return@repeat
        newStr.forEach { newCount[it - 'A'] += 1 }
        if ((0..25).sumOf { abs(count[it] - newCount[it]) } <= 2) ans += 1
    }

    println(ans)
}