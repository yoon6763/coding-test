package baekjoon.bronze.b4

fun main() {
    val (n, h, v) = readln().split(" ").map { it.toInt() }
    println(4 * (arrayOf(h * v, h * (n - v), (n - h) * v, (n - h) * (n - v)).maxOrNull()!!))
}