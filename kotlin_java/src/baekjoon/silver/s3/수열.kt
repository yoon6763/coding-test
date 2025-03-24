package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }
    var sum = arr.slice(0 until k).sum()
    var max = sum

    for (i in k until n) {
        sum += arr[i] - arr[i-k]
        max = maxOf(max, sum)
    }

    println(max)
}