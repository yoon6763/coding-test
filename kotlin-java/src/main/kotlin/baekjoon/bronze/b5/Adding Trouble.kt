package baekjoon.bronze.b5

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    if (a + b == c) println("correct!") else println("wrong!")
}