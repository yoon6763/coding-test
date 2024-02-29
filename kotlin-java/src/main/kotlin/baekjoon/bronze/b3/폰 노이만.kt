package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val (N, D, A, B, F) = readln().split(" ").map { it.toDouble() }
        println("$N %.6f".format(D / (A + B) * F))
    }
}