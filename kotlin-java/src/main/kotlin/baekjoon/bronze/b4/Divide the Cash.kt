package baekjoon.bronze.b4

fun main() {
    val (n, d) = readln().split(" ").map { it.toInt() }
    val arr = List(n) { readln().toDouble() }
    val sum = arr.sum()
    arr.forEach { println((d * (it / sum)).toInt()) }
}
