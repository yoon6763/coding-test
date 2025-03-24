package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val isPrime = { n: Int -> if (n == 1) false else (2..n / 2).none { n % it == 0 } }
    print(if (isPrime(n) && isPrime("$m$n".toInt())) "Yes" else "No")
}