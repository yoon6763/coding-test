package baekjoon.gold.g3

import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()

    val isPrime = Array(n + 1) { true }

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..n step i) {
                isPrime[j] = false
            }
        }
    }

    val primes = ArrayList<Int>()

    for (i in 2..n) {
        if (isPrime[i]) primes.add(i)
    }

    var left = 0
    var right = 0
    var sum = 0
    var resultCnt = 0

    while (true) {
        if (sum >= n) sum -= primes[left++]
        else if (right == primes.size) break
        else sum += primes[right++]
        if (sum == n) resultCnt++
    }

    println(resultCnt)
}