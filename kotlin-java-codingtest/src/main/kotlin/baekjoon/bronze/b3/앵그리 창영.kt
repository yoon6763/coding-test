package baekjoon.bronze.b3

import java.lang.StringBuilder
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val (n, w, h) = readLine().split(" ").map { it.toInt() }
    val diagonal = sqrt((w * w + h * h).toDouble())

    val sb = StringBuilder()

    repeat(n) {
        sb.append(if (readLine().toInt() <= diagonal) "DA" else "NE").append("\n")
    }

    print(sb)
}