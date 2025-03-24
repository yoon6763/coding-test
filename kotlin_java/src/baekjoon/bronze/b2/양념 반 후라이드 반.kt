package baekjoon.bronze.b2

fun main() {
    val (a, b, c, x, y) = readln().split(" ").map { it.toInt() }
    val result = ArrayList<Int>()
    result.add(a * x + b * y)
    result.add(c * 2 * maxOf(x, y))
    result.add(c * 2 * minOf(x, y) + a * (x - minOf(x, y)) + b * (y - minOf(x, y)))
    println(result.minOrNull())
}