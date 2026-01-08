package baekjoon.bronze.b5

fun main() {
    val (a, t) = readln().split(" ").map { it.toInt() }
    val p = 10 + 2 * (25 - a + t)
    println(if (p < 0) 0 else p)
}
