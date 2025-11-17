package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val (a, b, c) = readln().split(" ").map { it.toLong() }
    println(minOf(a * a + (b + c) * (b + c), b * b + (a + c) * (a + c), c * c + (b + a) * (b + a)))
}
