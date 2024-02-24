package baekjoon.bronze.b5

fun main() {
    repeat(readln().toInt()) {
        val (A, B, X) = readln().split(" ").map { it.toInt() }
        println(A * (X - 1) + B)
    }
}
