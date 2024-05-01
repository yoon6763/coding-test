package baekjoon.bronze.b3

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val (k, l) = readLine().split(" ").map { it.toBigInteger() }

    for (i in 2..<l.toInt()) {
        if (k.remainder(BigInteger.valueOf(i.toLong())).compareTo(BigInteger.ZERO) == 0) {
            println("BAD $i")
            return@with
        }
    }

    println("GOOD")
}
