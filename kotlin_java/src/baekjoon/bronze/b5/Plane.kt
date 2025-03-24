package baekjoon.bronze.b5

fun main() {
    val (n1, k1, n2, k2) = readln().split(" ").map { it.toInt() }
    println(n1 * k1 + n2 * k2)
}