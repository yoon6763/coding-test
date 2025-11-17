package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    println("${arr.minOrNull()} ${arr.maxOrNull()}")
}