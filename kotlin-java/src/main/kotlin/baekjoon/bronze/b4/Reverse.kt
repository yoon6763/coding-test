package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    val input = readln().split(" ")
    val line = input[0]
    val (s, e) = listOf(input[1].toInt(), input[2].toInt())
    println(line.substring(0..<s) + line.substring(e..<line.length))
}