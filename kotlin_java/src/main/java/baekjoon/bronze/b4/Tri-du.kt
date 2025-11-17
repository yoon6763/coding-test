package baekjoon.bronze.b4

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(if (a == b) a else maxOf(a, b))
}