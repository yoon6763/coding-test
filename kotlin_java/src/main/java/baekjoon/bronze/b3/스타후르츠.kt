package baekjoon.bronze.b3

fun main() {
    val (N, T, C, P) = readln().split(" ").map { it.toInt() }
    println((N - 1) / T * C * P)
}
