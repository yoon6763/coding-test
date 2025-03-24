package baekjoon.silver.s4

fun main() = with(System.`in`.bufferedReader()) {
    val isPrime = BooleanArray(1001) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..<isPrime.size) {
        if (!isPrime[i]) continue
        for (j in i + i..<isPrime.size step i) {
            isPrime[j] = false
        }
    }

    nextCase@ for (t in 0..<readLine().toInt()) {
        val n = readLine().toInt()

        for (i in 2..<isPrime.size) {
            for (j in i..<isPrime.size) {
                for (k in j..<isPrime.size) {
                    if (isPrime[i] && isPrime[j] && isPrime[k] && i + j + k == n) {
                        println("$i $j $k")
                        continue@nextCase
                    }
                }
            }
        }
        println("0")
    }
}