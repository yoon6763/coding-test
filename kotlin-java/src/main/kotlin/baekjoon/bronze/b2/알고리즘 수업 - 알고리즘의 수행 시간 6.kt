package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toLong()
    println((n * (n - 1) * (n - 2) / 6))
    println(3)
}