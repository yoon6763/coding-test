package baekjoon.bronze.b3

import java.math.BigInteger

fun main() {
    val input = readln().split(" ")
    val a = BigInteger(input[0])
    val b = BigInteger(input[1])

    if (a.compareTo(BigInteger.ZERO) == -1 && b.compareTo(BigInteger.ZERO) == -1) {
        println(a.divide(b).add(BigInteger.ONE))
        println(a.remainder(b).subtract(b))
    } else if (a.compareTo(BigInteger.ZERO) == -1 && b.compareTo(BigInteger.ZERO) == 1) {
        println(a.divide(b).subtract(BigInteger.ONE))
        println(a.remainder(b).add(b))
    } else {
        println(a.divide(b))
        println(a.remainder(b))
    }
}