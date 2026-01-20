package baekjoon.bronze.b2

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(if (a % 2 == 1 && b % 2 == 1) a * b - 1 else a * b)
}
