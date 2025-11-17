package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    println("Case #${it + 1}: ${
            when {
                n <= 25 -> "World Finals"
                n <= 1000 -> "Round 3"
                n <= 4500 -> "Round 2"
                else -> "Round 1"
            }}")
}