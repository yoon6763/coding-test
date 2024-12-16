package baekjoon.bronze.b3

fun main() {
    val x = readln().toInt()
    val n = readln().toInt()
    println(x * (n + 1) - List(n) { readln().toInt() }.sum())
}
