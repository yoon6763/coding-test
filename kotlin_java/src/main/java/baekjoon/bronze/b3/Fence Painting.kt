package baekjoon.bronze.b3

fun main() {
    val (a, b) = readln().split(" ").map(String::toInt)
    val (c, d) = readln().split(" ").map(String::toInt)
    println(if (c >= b || d <= a) b - a + d - c else maxOf(b, d) - minOf(a, c))
}
