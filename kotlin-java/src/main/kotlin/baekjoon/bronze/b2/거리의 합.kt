package baekjoon.bronze.b2

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toLong() }
    var ans = 0L
    for (i in 0..<n) {
        for (j in 0..<n) {
            ans += abs(arr[i] - arr[j])
        }
    }
    println(ans)
}