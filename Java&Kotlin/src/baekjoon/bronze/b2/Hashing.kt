package baekjoon.bronze.b2

import kotlin.math.pow

fun main() {

    val n = readLine()!!.toInt()
    val input = readLine()!!
    val M = 1234567891

    var pow: Long = 1
    var result: Long = 0

    for (i in 0 until n) {
        result += (input[i] - 'a' + 1) * pow % M
        pow = pow * 31 % M
    }
    println(result % M)
}