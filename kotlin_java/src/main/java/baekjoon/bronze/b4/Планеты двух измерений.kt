package baekjoon.bronze.b4

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }.sorted()
    if (a == b) println(a * 2)
    else println(a * 2 + 1)
}