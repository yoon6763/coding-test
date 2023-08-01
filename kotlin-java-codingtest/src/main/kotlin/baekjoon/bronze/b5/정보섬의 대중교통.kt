package baekjoon.bronze.b5

fun main() {
    val (n, a, b) = readln().split(" ").map { it.toInt() }
    if (a > b) println("Subway")
    if (a < b) println("Bus")
    if (a == b) println("Anything")
}