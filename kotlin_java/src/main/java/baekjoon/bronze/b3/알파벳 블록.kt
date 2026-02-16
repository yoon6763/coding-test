package baekjoon.bronze.b3

fun main() {
    val (s, c, o, n) = readln().split(" ").map { it.toLong() }
    println(minOf((s + n) / 3, (c + 2 * o) / 6))
}
