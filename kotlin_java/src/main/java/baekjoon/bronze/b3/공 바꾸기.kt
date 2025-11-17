package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { it }
    repeat(m) {
        val (i, j) = readLine().split(" ").map { it.toInt() }
        arr[i] = arr[j].also { arr[j] = arr[i] }
    }
    println(arr.slice(1..n).joinToString(" "))
}