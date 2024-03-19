package baekjoon.bronze.b4

fun main() {
    val (d, h, m) = readln().split(" ").map { it.toInt() }
    val ans = (d - 11) * 24 * 60 + (h - 11) * 60 + (m - 11)
    println(if (ans < 0) -1 else ans)
}
