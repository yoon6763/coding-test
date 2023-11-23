package baekjoon.gold.g5

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = Array(n) { st.nextToken().toInt() }

    val dpRight = Array(n) { 0 }
    val dpLeft = Array(n) { 0 }

    dpLeft[0] = arr[0]
    dpRight[n - 1] = arr[n - 1]

    for (i in 1 until n) {
        dpLeft[i] = maxOf(arr[i], dpLeft[i - 1] + arr[i])
    }
    for (i in n - 2 downTo 0) {
        dpRight[i] = maxOf(arr[i], dpRight[i + 1] + arr[i])
    }

    var max = dpLeft.maxOrNull()!!

    for (i in 1 until n - 1) {
        max = maxOf(max, dpLeft[i - 1] + dpRight[i + 1])
    }

    println(max)
}