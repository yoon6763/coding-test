package baekjoon.bronze.b4

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val arr = readLine().split(" ").map { it.toInt() }.sorted()
    println(abs(arr[0] + arr[3] - arr[1] - arr[2]))
}