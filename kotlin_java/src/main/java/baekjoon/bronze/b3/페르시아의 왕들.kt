package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (a, b, c, d) = readln().split(" ").map { it.toInt() }
        if (listOf(a, b, c, d).all { it == 0 }) break
        println("${c - b} ${d - a}")
    }
}