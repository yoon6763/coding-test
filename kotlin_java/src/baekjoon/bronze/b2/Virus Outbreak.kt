package baekjoon.bronze.b2

import java.math.BigInteger

fun main() {
    val arr = Array(491) { BigInteger.ZERO }
    arr[1] = BigInteger.ONE
    arr[2] = BigInteger.ONE

    for (i in 3..490) {
        arr[i] = arr[i - 1] + arr[i - 2]
    }

    while (true) {
        val n = readln().toInt()
        if (n == -1) break
        println("Hour $n: ${arr[n]} cow(s) affected")
    }
}
