package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = List(n) { readln().toCharArray() }
    val rotated = List(m) { i -> List(n) { j -> arr[n - j - 1][i] } }
    rotated.forEach { println(it.joinToString("")) }
}