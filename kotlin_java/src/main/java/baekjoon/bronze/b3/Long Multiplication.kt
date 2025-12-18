package baekjoon.bronze.b3

import java.math.BigInteger

fun main() {
    val aStr = readln()
    val bStr = readln()

    val a = BigInteger(aStr)
    val b = BigInteger(bStr)

    println(aStr)
    println(bStr)

    for (i in bStr.length - 1 downTo 0) {
        val digit = bStr[i] - '0'
        println(a * BigInteger.valueOf(digit.toLong()))
    }

    println(a * b)
}
