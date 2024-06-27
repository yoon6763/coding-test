package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val sb = StringBuilder()

    for (i in 1..readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toLong() }
        var sum = b * (b + 1) / 2

        if (a < 0) sum -= abs(a) * (abs(a) + 1) / 2
        else if (a > 1) sum -= (a - 1) * a / 2

        sb.append("Scenario #$i:\n$sum\n\n")
    }

    print(sb)
}