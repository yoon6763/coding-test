package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }.apply { if (all { it == 0 }) return }
        val ans = c - a + b
        println(if (ans % b != 0 || (a > c)) "X" else ans / b)
    }
}
