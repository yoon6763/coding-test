package baekjoon.bronze.b3

fun main() {
    var (w, h, d) = readln().split(" ").map { it.toInt() }
    w -= 2 * d
    h -= 2 * d
    println(if (w <= 0 || h <= 0) 0 else w * h)
}