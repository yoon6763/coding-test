package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (y, m, d) = readln().split(" ").map { it.toInt() }
    println(if (y < 1989 || (y == 1989 && m < 2) || (y == 1989 && m == 2 && d < 28)) "Yes" else "No")
}
