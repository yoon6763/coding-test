package baekjoon.bronze.b5

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(b/a * c * 3)
}