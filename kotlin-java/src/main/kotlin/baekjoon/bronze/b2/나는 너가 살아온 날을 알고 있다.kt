package baekjoon.bronze.b2

import java.time.LocalDate

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val (d, m, y) = readLine().split(" ").map { it.toInt() }
        if (y == 0 && m == 0 && d == 0) break
        val first = LocalDate.of(y, 1, 1)
        val second = LocalDate.of(y, m, d)
        val diff = second.toEpochDay() - first.toEpochDay()
        sb.append("${diff + 1}\n")
    }
    print(sb)
}