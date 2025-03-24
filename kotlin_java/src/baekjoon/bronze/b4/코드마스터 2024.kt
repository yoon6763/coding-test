package baekjoon.bronze.b4

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    println(m + m * k)
}