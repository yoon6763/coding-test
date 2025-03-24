package baekjoon.bronze.b4

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    if (a >= b) println(b) else println(a + 1)
}