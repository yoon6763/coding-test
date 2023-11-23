package baekjoon.bronze.b1

import java.lang.StringBuilder

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().split(" ").map { it.toInt() } }
    val sb = StringBuilder()

    for (i in 0 until n) {
        val sb2 = StringBuilder()

        for (j in 0 until n) sb2.append("${arr[i][j]} ".repeat(k))

        sb2.append("\n")
        sb.append(sb2.repeat(k))
    }
    print(sb)
}