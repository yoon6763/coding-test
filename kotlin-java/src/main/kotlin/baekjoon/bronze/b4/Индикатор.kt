package baekjoon.bronze.b4

fun main() {
    val (m, a, b) = List(3) { readln().toInt() }
    println((b - a + m) % m)
}