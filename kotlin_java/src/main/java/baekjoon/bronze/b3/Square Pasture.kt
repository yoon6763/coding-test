package baekjoon.bronze.b3

fun main() {
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
    val (x3, y3, x4, y4) = readln().split(" ").map { it.toInt() }
    println(maxOf(maxOf(x4, x2) - minOf(x3, x1), maxOf(y4, y2) - minOf(y3, y1)).let { it * it })
}