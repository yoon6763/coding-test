package baekjoon.bronze.b4


fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    println(if (n % (k - m) == 0) n / (k - m) else n / (k - m) + 1)
}