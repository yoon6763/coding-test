package baekjoon.bronze.b4

fun main() {
    val (n, u, l) = readln().split(" ").map { it.toInt() }
    var condition = 0
    if (n >= 1000) condition = 1
    if (condition == 1 && (u >= 8000 || l >= 260)) condition += 1

    println(
        when (condition) {
            0 -> "Bad"
            1 -> "Good"
            2 -> "Very Good"
            else -> "?"
        }
    )
}
