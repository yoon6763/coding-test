package baekjoon.bronze.b4

fun main() {
    val (a, b) = readln().split(" ").map { it.toDouble() }
    println(
        when {
            a / b < 0.2 -> "weak"
            a / b < 0.4 -> "normal"
            a / b < 0.6 -> "strong"
            else -> "very strong"
        }
    )
}
