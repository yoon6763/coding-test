package baekjoon.bronze.b1

fun main() {
    val (n, m, k) = readln().split(' ').map { it.toInt() }
    val arr = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }
    val sum = Array(n) { 0 }
    for (i in 0 until m) {
        for (j in 0 until n) {
            sum[j] += arr[j][i]
            if (sum[j] < k) continue
            println("${j + 1} ${i + 1}")
            return
        }
    }
}