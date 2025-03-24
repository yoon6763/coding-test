package baekjoon.silver.s2

fun main() {
    val k = readln().toInt()
    val isPrime = BooleanArray(8000001) { true }

    for (i in 2..isPrime.size / 2) {
        if (isPrime[i]) {
            for (j in i * 2..<isPrime.size step i) {
                isPrime[j] = false
            }
        }
    }

    var count = 0
    for (i in 2..isPrime.size) {
        if (isPrime[i]) {
            count += 1
            if (count == k) {
                println(i)
                break
            }
        }
    }
}