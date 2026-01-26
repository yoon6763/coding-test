package baekjoon.bronze.b3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }

    val times = readln().split(" ").map { it.toInt() }
    val maxTime = times.maxOrNull()!!

    val totalMs = maxTime * s
    print((totalMs + 999) / 1000 )
}
