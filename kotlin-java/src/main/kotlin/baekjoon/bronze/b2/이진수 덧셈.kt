package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toBigInteger(2) }
    println((n + m).toString(2))
}