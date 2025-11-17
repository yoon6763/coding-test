package baekjoon.bronze.b4

import java.math.BigInteger

fun main() {
    var num = BigInteger("1")
    val n = readln().toInt()
    for (i in 2..n) num *= BigInteger(i.toString())
    println(num / BigInteger("60") / BigInteger("60") / BigInteger("24") / BigInteger("7"))
}