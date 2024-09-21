package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = List(n) { readln().toInt() }
    val a = arr.count { it == 1 }
    print(minOf(a, n - a))
}