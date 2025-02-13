package baekjoon.bronze.b4

fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    println("${n + 1} ${k * n + 1}")
}
