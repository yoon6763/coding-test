package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (n, d) = readln().split(" ").map { it.toInt() }
    var cnt = 0
    repeat(n) {
        val (v, f, c) = readln().split(" ").map { it.toInt() }
        if (d.toDouble() / v * c <= f) cnt++
    }
    println(cnt)
}
