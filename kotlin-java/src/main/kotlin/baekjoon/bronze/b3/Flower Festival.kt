package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val arr = Array(n) { readln().split(" ").map { it.toInt() } }
    val time = arr.minOf { (x, v) -> (m - x) / v.toDouble() }

    println(arr.indexOfFirst { (x, v) -> (x + v * time).toInt() == m } + 1)
}