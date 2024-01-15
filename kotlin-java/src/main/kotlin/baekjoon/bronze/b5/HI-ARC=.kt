package baekjoon.bronze.b5

fun main() {
    val (h, i, a, r, c) = readln().split(" ").map { it.toInt() }
    val a1 = h * i
    val a2 = a * r * c
    println(a1 - a2)
}