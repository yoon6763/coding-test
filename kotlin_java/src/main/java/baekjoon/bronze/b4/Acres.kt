package baekjoon.bronze.b4

fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    println((w * h) / (4840 * 5) + if ((w * h) % (4840 * 5) == 0) 0 else 1)
}