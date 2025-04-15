package baekjoon.silver.s2

fun main() {
    val max = 1000000
    val isPrime = BooleanArray(max + 1) { false }
    val prime = mutableListOf<Int>()

    isPrime[0] = true
    isPrime[1] = true
    for (i in 2..max) {
        if (isPrime[i]) continue
        prime.add(i)
        for (j in i * 2..max step i) {
            isPrime[j] = true
        }
    }

    repeat(readln().toInt()) {
        val n = readln().toInt()
        println(
            prime
            .asSequence()
            .takeWhile { it < n }
            .count { !isPrime[n - it] && it <= n - it })
    }
}
