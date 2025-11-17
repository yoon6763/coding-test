package baekjoon.bronze.b3

import java.math.BigDecimal
import java.math.MathContext

fun main() {
    val (a, b, c) = readln().split(" ").map { BigDecimal(it) }
    println(a.multiply(b).divide(c, MathContext.DECIMAL128).toPlainString())
}
