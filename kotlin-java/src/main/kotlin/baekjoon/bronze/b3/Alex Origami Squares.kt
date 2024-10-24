package baekjoon.bronze.b3

fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val a = maxOf(h, w)
    val b = minOf(h, w)
    println(maxOf(if (a / 3.0 <= b) a / 3.0 else b.toDouble(), b / 2.0))
}
