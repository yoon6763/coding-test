package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    println(readln().split(" ").map { it.toInt() }.mapIndexed { i, v -> v - (n - i) }.maxOrNull() ?: 0)
}