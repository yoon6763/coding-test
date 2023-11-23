package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val (a, i) = readLine().split(" ").map { it.toInt() }
    println(a * (i - 1) + 1)
}