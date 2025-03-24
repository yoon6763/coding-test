package baekjoon.bronze.b4

fun main() {
    val (A, B) = readln().split(" ").map { it.toInt() }
    val (C, D) = readln().split(" ").map { it.toInt() }
    println(((A + B - 1) % 4 + C + D - 1) % 4 + 1)
}
