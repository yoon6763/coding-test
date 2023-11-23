package baekjoon.gold.g1

import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toLong()
    var result = n

    for (p in 2..sqrt(n.toDouble()).toInt()) {
        // p가 소인수라면
        if (n % p == 0L) {
            result -= result / p
            while (n % p == 0L) {
                n /= p
            }
        }
    }

    if (n > 1) result -= result / n
    println(result)
}