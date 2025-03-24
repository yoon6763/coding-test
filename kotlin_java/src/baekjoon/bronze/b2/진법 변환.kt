package baekjoon.bronze.b2

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val nb = readLine().split(" ")
    val n = nb[0]
    val b = nb[1].toInt()

    println(BigInteger(n, b).toString(10))
}