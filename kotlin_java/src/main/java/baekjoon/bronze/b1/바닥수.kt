package baekjoon.bronze.b1

fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    println("1".repeat(l - 1) + n.toString())
}
