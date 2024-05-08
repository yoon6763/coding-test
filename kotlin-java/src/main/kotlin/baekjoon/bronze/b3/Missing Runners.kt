package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    println((1..n).sum() - arr.sum())
}
