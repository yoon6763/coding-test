package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val avg = (a + b + c) / 3
    println(avg - a + avg - (b - (avg - a)))
}