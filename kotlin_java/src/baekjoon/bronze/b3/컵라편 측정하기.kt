package baekjoon.bronze.b3

fun main() {
    val k = readln().toDouble()
    val (d1, d2) = readln().split(" ").map { it.toDouble() }

    println(k * k - (d1 - d2) * (d1 - d2) / 4)
}