package baekjoon.bronze.b5

import java.math.BigInteger
fun main() {
    var result = BigInteger.ONE
    for (i in 2..readln().toInt()) result *= i.toBigInteger()
    println(result)
}