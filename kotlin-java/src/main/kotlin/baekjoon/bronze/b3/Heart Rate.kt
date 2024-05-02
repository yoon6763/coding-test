package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val (b, p) = readln().split(" ").map { it.toDouble() }
        val bpm = 60 * b / p
        val minabpm = 60 * (b - 1) / p
        val maxabpm = 60 * (b + 1) / p

        println("$minabpm $bpm $maxabpm")
    }
}