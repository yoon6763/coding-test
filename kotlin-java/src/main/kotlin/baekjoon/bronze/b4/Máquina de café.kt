package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = List(3) { readln().toInt() }
    println(listOf(b * 2 + c * 4, a * 2 + c * 2, a * 4 + b * 2).minOrNull()!!)
}