package baekjoon.bronze.b2

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val (a, d) = readln().split(" ").map { it.toInt() }
    val (sr, sc) = readln().split(" ").map { it.toInt() }

    println(if (sr == r && (d + sr) % 2 == 1) "YES!" else "NO...")
}
