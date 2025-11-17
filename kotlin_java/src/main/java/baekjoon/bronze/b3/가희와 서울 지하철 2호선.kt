package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val inner = (b - a + 43) % 43
    val outer = (a - b + 43) % 43
    println(
        when {
            inner < outer -> "Inner circle line"
            inner > outer -> "Outer circle line"
            else -> "Same"
        }
    )
}