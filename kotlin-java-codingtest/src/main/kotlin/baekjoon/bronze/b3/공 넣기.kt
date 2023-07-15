package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { 0 }
    repeat(m) {
        val (left, right, num) = readln().split(" ").map { it.toInt() }
        arr.fill(num, left - 1, right)
    }
    println(arr.joinToString(" "))
}