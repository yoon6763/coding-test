package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (n, x, y) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }

    println(
        when {
            arr.first() == x && arr.last() == y -> "BOTH"
            arr.first() == x -> "EASY"
            arr.last() == y -> "HARD"
            else -> "OKAY"
        }
    )
}
