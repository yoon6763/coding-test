package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val (x, s) = readln().split(" ").map { it.toInt() }
    println(if (((1..n).maxOfOrNull { readln().split(" ").map { it.toInt() }.let { (c, p) -> if (c <= x) p else -1 } } ?: -1) > s) "YES" else "NO")
}