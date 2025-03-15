package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (l, r, s) = readln().split(" ").map { it.toInt() }
    val (ls, rs) = listOf(s - l, r - s)
    println(if (ls < rs) ls * 2 + 1 else 2 * rs)
}