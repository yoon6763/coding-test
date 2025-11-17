package baekjoon.silver.s4

fun main() = repeat(readln().toInt()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(n - 1)
    repeat(m) {
        readln()
    }
}