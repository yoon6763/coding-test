package baekjoon.bronze.b3

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }
    val t = readln().toInt()

    val dist = kotlin.math.abs(a - c) + kotlin.math.abs(b - d)

    if (t >= dist && (t - dist) % 2 == 0) {
        println("Y")
    } else {
        println("N")
    }
}