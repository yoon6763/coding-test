package baekjoon.bronze.b3

fun main() {
    val (X, Y) = readln().split(" ").map { it.toLong() }
    val N = readln().toInt()

    repeat(N) {
        val (x, y) = readln().split(" ").map { it.toLong() }
        println(if (x == X || y == Y) 0 else 1)
    }
}