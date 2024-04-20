package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(if (c in a..<b) 1 else 0)
}