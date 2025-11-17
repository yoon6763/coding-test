package baekjoon.bronze.b3

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val t = readln().toInt()
    println(if (t <= 30) a else a + ((t - 30 + b - 1) / b) * c)
}
