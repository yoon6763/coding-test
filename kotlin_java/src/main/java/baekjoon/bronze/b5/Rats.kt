package baekjoon.bronze.b5

fun main() {
    val (n1, n2, n12) = readln().split(" ").map { it.toInt() }
    println((n1 + 1) * (n2 + 1) / (n12 + 1) - 1)
}