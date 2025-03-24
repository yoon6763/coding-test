package baekjoon.bronze.b1

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val (n, b) = readLine().split(" ")
    var num = BigInteger(n)

    val sb = StringBuilder()
    while (num > BigInteger.ZERO) {
        val mod = (num % BigInteger(b)).toInt()
        if (mod < 10) sb.append(mod)
        else sb.append('A' + mod - 10)
        num /= BigInteger(b)
    }
    print(sb.reversed())
}