package baekjoon.bronze.b4

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val size = n * m
    val count = List(n) { readln().count { it == '1' } }.sum()
    println(minOf(size - count, count))
}