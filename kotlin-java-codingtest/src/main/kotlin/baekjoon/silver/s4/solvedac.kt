package baekjoon.silver.s4


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { readLine().toInt() }.sorted()

    val cutLine = Math.round(n * 0.15).toInt()

    var sum = 0
    for (i in cutLine until n - cutLine) {
        sum += arr[i]
    }

    println(Math.round(sum.toDouble() / (n - cutLine * 2)).toInt())
}