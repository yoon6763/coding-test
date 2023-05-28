package baekjoon.bronze.b4

fun main() {
    val line = readln().split(" ")
    println(if (line[0].toInt() + line[2].toInt() == line[4].toInt()) "YES" else "NO")
}