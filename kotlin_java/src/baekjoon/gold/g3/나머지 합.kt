package baekjoon.gold.g3

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(m + 1) { 0L }

    var sum = 0
    val st = StringTokenizer(readLine())

    for (i in 0 until n) {
        sum += st.nextToken().toInt() % m
        arr[sum % m]++
    }
    var cnt = 0L

    for (i in 0 until m) {
        cnt += arr[i] * (arr[i] - 1) / 2
    }
    println(cnt + arr[0])
}