package baekjoon.bronze.b3

fun main() {
    val (x, k) = readln().split(" ").map { it.toInt() }
    val a = if (7000 * k <= 1000 * x) 7000 * k else 0
    val b = if (3500 * k <= 1000 * x) 3500 * k else 0
    val c = if (1750 * k <= 1000 * x) 1750 * k else 0
    println(listOf(a, b, c).maxOrNull())
}
