package baekjoon.bronze.b3

import java.math.BigInteger
import kotlin.math.abs

fun main() {
    readln()
    val e = readln().toInt()
    val (p, n) = readln().split(" ").map { it.toLong() }.partition { it > 0 }

    print((p.sortedDescending() + if (e % 2 == 0) n.sortedByDescending { abs(it) } else emptyList())
        .sumOf { BigInteger.valueOf(it).pow(e) })
}