package baekjoon.bronze.b4

fun main() {
    val (P, Q) = readln().split(" ").map { it.toInt() }
    val (A, B) = readln().split(" ").map { it.toInt() }
    println(if (P < Q) P * A + (Q - P) * B else Q * A)
}
