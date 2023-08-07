package baekjoon.bronze.b4

fun main() {
    val (n, m) = readln().split(" ").map { it.toDouble() }
    println(if (n - (n * m / 100) >= 100) "0" else "1")
}