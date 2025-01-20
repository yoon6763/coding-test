package baekjoon.silver.s3

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val pArr = IntArray(t + 1)
    val qArr = Array(t + 1) { BigInteger.ZERO }
    var len = 0

    for (i in 1..t) {
        val (p, q) = readLine().split(" ").let { it[0].toInt() to BigInteger(it[1]) }
        pArr[i] = p
        qArr[i] = q
        len = maxOf(len, p)
    }

    val dp = Array(10001) { BigInteger.ZERO }
    dp[1] = BigInteger.ONE
    dp[2] = BigInteger.ONE

    for (i in 3..len) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    val sb = StringBuilder()
    for (i in 1..t) {
        sb.appendLine("Case #$i: ${dp[pArr[i]].remainder(qArr[i])}")
    }

    print(sb)
}