package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    val (g, c, e) = readln().split(" ").map { it.toInt() }
    println(
        maxOf((e - c), 0) * when (g) {
            1 -> 1
            2 -> 3
            else -> 5
        }
    )
}