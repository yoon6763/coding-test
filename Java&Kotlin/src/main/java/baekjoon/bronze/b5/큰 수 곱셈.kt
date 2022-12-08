package baekjoon.bronze.b5

import java.math.BigDecimal

fun main() {
    readln().split(" ").map { BigDecimal(it) }.let {
        println(it[0] * it[1])
    }
}