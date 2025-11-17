package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    println(Array(n) { readLine() }.sorted()[m - 1])
}