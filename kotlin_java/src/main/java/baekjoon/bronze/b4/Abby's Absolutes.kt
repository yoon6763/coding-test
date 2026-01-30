package baekjoon.bronze.b4

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val mid = (n + 1) / 2
    println(
        readln().split(" ")
            .map { it.toInt() }
            .joinToString(" ") { x -> if (x > mid) n.toString() else "1" }
    )
}