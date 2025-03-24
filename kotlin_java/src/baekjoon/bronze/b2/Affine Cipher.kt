package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val result = StringBuilder()
    readln().forEach { result.append('A' + (a * (it - 'A') + b) % 26) }
    println(result)
}