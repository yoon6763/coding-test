package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(n * m - 1)
}