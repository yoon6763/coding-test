package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val max = maxOf(a, b, c)
    println(max - a + max - b + max - c)
}