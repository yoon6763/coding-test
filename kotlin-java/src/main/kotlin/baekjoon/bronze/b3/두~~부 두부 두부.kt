package baekjoon.bronze.b3

fun main() {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    println(((m - 1) + (k - 3) % n + n) % n + 1)
}