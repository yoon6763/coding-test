package baekjoon.bronze.b3

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val target = c.toString()[0]
    println((a..b).sumOf { i -> i.toString().count { it == target } })
}