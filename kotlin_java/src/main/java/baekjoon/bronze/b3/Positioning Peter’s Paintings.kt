package baekjoon.bronze.b3

fun main() {
    val (a, b, x, y) = readln().split(' ').map { it.toLong() }
    println(minOf(2 * (a + x + maxOf(b, y)), 2 * (maxOf(a, x) + b + y)))
}
