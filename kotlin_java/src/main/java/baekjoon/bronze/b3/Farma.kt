package baekjoon.bronze.b3

fun main() {
    val (x, y) = readln().split(" ").map { it.toLong() }

    val cows = (y - 2 * x) / 2
    val chickens = x - cows

    println("$chickens $cows")
}