package baekjoon.bronze.b3

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val sum = List(k) { readln().toDouble() }.sum()
    println("${(sum - 3 * (n - k)) / n} ${(sum + 3 * (n - k)) / n}")
}