package baekjoon.bronze.b3

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        var (a, b, c, d) = readLine().split(" ").map(String::toInt)
        if (a == 0 && b == 0 && c == 0 && d == 0) break

        var cnt = 0

        while (a != b || b != c || c != d) {
            cnt++
            val tempA = abs(a - b)
            val tempB = abs(b - c)
            val tempC = abs(c - d)
            val tempD = abs(d - a)
            a = tempA
            b = tempB
            c = tempC
            d = tempD
        }
        sb.append(cnt).append("\n")
    }

    print(sb)
}