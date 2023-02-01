package baekjoon.silver.s4

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = readLine().toInt()
    }

    arr.sort()
    var max = arr[0] * n

    for (i in 0 until n) {
        max = max(max, arr[i] * (n - i))
    }

    println(max)
}