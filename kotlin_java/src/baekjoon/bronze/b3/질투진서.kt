package baekjoon.bronze.b3

fun main() {
    val (n, x, y) = readln().split(" ").map { it.toInt() - 1 }
    val arr = Array(n + 1) { readln().split(" ").map { it.toInt() } }
    println(if (arr[x].any { it > arr[x][y] } || (0..<x).any { arr[it][y] > arr[x][y] }) "ANGRY" else "HAPPY")
}