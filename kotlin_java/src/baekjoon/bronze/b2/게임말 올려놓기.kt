package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    println(if (n == 1 || m == 1) 0 else (n - 1) * (m - 1) * 2)
}