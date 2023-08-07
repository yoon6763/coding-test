package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().toDouble() }.sorted().toDoubleArray()

    println("%.2f".format(arr.sliceArray(k until n - k).average()))
    for (i in 0 until k) {
        arr[i] = arr[k]
        arr[n - 1 - i] = arr[n - k - 1]
    }
    println("%.2f".format(arr.average()))
}