package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = Array(3) { readln().toInt() }
    println(a + b - c)
    println((a.toString() + b.toString()).toInt() - c)
}