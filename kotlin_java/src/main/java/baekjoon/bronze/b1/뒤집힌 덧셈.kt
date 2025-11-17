package baekjoon.bronze.b1

fun main() {
    val (a, b) = readln().split(" ").map { it.reversed().toInt() }
    println((a + b).toString().reversed().toInt())
}