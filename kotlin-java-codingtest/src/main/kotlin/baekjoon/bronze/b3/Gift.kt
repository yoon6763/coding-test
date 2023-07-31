package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().toInt() }
    var cnt = 0
    for (i in 1 until n) if (arr[i] - arr[i - 1] >= m) cnt++
    println(cnt)
}