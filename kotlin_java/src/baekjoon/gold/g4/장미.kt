package baekjoon.gold.g4

import kotlin.math.ceil

fun main() {
    // A개 B원
    // C개 D원
    var (n, a, b, c, d) = readln().split(" ").map { it.toLong() }

    if (b * c < d * a) {
        var temp = a
        a = c
        c = temp

        temp = b
        b = d
        d = temp
    }

    var result = Long.MAX_VALUE
    for (i in 0..<c) {
        val index = maxOf(ceil((n - i * a).toDouble() / c).toLong(), 0)
        result = result.coerceAtMost(i * b + index * d)
        if (index == 0L) break
    }

    println(result)
}