package baekjoon.bronze.b3

fun main() {
    val n = readln().toLong()
    println(n * (n - 1) * (n - 2) * (n - 3) * (n - 4) / 120)
}