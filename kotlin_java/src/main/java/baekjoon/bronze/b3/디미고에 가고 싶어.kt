package baekjoon.bronze.b3

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }

    if (a % 2 == 0 && b % 2 != 0) {
        println((b - a) / 2 + 2)
    } else {
        println((b - a) / 2 + 1)
    }
}