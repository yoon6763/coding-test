package baekjoon.bronze.b3

import kotlin.math.sqrt

fun main() {
    val t = readln().toInt()

    for (c in 0..<t) {
        val n = readln().toInt()
        var sum = 1
        for (i in 2..sqrt(n.toDouble()).toInt()) if (n % i == 0) sum += if (i * i != n) i + n / i else i
        println(
            when {
                sum < n -> "$n is a deficient number."
                sum == n -> "$n is a perfect number."
                else -> "$n is an abundant number."
            }
        )

        if (c != t - 1) println()
    }
}
