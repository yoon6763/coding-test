package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, x, k) = readLine().split(" ").map { it.toInt() }

    val cups = Array(n + 1) { false }
    cups[x] = true

    repeat(k) {
        val (cup1, cup2) = readLine().split(" ").map { it.toInt() }
        cups[cup1] = cups[cup2].also { cups[cup2] = cups[cup1] }
    }

    println(cups.indexOf(true))
}