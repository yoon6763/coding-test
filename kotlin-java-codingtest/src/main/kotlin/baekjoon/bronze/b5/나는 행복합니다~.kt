package baekjoon.bronze.b5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    println("${k / m} ${k % m}")
}