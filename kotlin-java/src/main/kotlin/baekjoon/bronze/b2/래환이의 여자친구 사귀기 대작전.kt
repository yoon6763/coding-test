package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }

    println(arr.indices.reversed().find { i ->
        arr.takeLast(n - i).sum() >= m
    }?.plus(1) ?: -1)
}