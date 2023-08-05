package baekjoon.silver.s4

fun main() {
    val n = readln().toInt()

    val arrSize = 1000000
    val isPrime = Array(arrSize) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2 until arrSize) {
        if (isPrime[i]) {
            for (j in i * 2 until arrSize step i) isPrime[j] = false
        }
    }

    var idx = 0
    for (i in 2 until arrSize) {
        if (isPrime[i]) idx++
        if (idx == n) {
            println(i)
            break
        }
    }
}