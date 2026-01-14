package baekjoon.bronze.b3

fun main() {
    val n = readln().toDouble()
    val x = readln().toDouble()
    println((1.0 / (1.0 - x / 100.0) - 1.0) * 100.0)
}
