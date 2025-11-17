package baekjoon.bronze.b4

fun main() {
    val a = readln().split(" ").map { it.toInt() }[1]
    println(readln().split(" ").map { it.toInt() }.sumOf { it / a })
}