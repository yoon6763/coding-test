package baekjoon.bronze.b3

fun main() {
    val (n, a, b, c) = readln().split(" ").map { it.toInt() }
    val ans = if (n > 1) if (a < c || b < c) (n - 1) * minOf(a, b) else minOf(a, b) + (n - 2) * c else 0
    println("${ans / 100} ${ans % 100}")
}
