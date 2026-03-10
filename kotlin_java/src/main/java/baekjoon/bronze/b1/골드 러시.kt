package baekjoon.bronze.b1

import java.lang.Long.bitCount

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, a, b) = readln().split(" ").map { it.toLong() }
        val ans = bitCount(a) + bitCount(b) - 1
        println(ans)
    }
}