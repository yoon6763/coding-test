package baekjoon.bronze.b4

fun main() {
    var (n, k) = Array(2) { readln().toInt() }
    val tmp = minOf(k + 60, n)
    println(tmp * 1500 + (n - tmp) * 3000)
}