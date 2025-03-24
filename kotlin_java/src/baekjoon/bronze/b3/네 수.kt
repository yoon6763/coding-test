package baekjoon.bronze.b3

import java.math.BigDecimal

fun main() {
    val (a, b, c, d) = readln().split(" ")
    println(BigDecimal(a + b) + BigDecimal(c + d))
}