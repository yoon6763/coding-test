package baekjoon.bronze.b4

fun main() {
    val (g, p, t) = readln().split(" ").map { it.toInt() }
    val a = g + p * t
    val b = g * p
    println(
        when {
            b < a -> 1
            b > a -> 2
            else -> 0
        }
    )
}
