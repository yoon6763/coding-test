package baekjoon.bronze.b4

fun main() {
    val (a, x, b, y, t) = Array(5) { readln().toInt() }
    println("${a + maxOf(t - 30, 0) * x * 21} ${b + maxOf(t - 45, 0) * y * 21}")
}
