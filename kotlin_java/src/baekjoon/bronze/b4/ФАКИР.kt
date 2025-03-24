package baekjoon.bronze.b4

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    println(arr.sum() - arr.min() + 1)
}