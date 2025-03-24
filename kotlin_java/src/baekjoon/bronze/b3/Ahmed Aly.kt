package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val line = readln().split(" ")
    println("Case ${it + 1}: ${if (line[0].toInt() + (if (line[1] == "+") 1 else -1) * line[2].toInt() == line[4].toInt()) "YES" else "NO"}")
}