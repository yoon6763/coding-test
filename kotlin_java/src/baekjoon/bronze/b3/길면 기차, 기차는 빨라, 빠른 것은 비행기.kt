package baekjoon.bronze.b3

import kotlin.math.abs
import kotlin.math.round

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (M, A, B) = readLine().split(" ").map(String::toInt).let { if (it.all { it == 0 }) return@with else it }
        val diff = round(abs(M / A.toDouble() * 3600 - M / B.toDouble() * 3600)).toInt()
        println("${diff / 3600}:${"%02d".format(diff % 3600 / 60)}:${"%02d".format(diff % 3600 % 60)}")
    }
}