package baekjoon.bronze.b2

import java.math.BigInteger

fun main() {
    var num = readln().toBigInteger()
    var answer = 64

    val two = 2.toBigInteger()
    while (num % two == BigInteger.ZERO) {
        num /= two
        answer--
    }

    println(answer)
}