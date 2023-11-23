package baekjoon.bronze.b5

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    println(input[0] * 56 + input[1] * 24 + input[2] * 14 + input[3] * 6)
}