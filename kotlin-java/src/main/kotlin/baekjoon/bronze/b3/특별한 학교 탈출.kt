package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().toCharArray() }
    println((0..<m).firstOrNull { i -> (0..<n).none { j -> arr[j][i] == 'O' } }?.plus(1) ?: "ESCAPE FAILED")
}