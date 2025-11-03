package baekjoon.bronze.b4

fun main() {
    val (s, d, t) = readln().split(' ').map { it.toDouble() }
    if (s * 5280 / 3600 * t >= d) println("MADE IT")
    else println("FAILED TEST")
}
