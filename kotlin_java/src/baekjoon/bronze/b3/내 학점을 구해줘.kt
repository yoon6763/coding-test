package baekjoon.bronze.b3

import java.math.BigDecimal

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        var n = 0
        var bigDecimal = BigDecimal("0.0")

        repeat(readLine().toInt()) {
            val (a, b) = readLine().split(" ")
            n += a.toInt()
            bigDecimal = bigDecimal.plus(BigDecimal(a) * BigDecimal(b))
        }

        sb.append("$n ${bigDecimal / BigDecimal(n.toDouble().toString())}\n")
    }
    println(sb.toString())
}