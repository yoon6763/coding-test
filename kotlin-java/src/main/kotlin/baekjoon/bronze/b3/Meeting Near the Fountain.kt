package baekjoon.bronze.b3


fun main() {
    val (n, t) = readln().split(" ").map { it.toLong() }
    val m = readln().toLong()
    val (x, y) = readln().split(" ").map { it.toLong() }
    val a = 1.0 * m / (x * 60)
    val b = 1.0 * (n - m) / (y * 60)
    println(if (a + b < t) 0 else (a + b - t + 1).toInt())
}