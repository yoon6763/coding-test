package baekjoon.gold.g5

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    // n 심사대 수, m 친구 수
    val line = readLine().split(" ")
    val n = line[0].toInt()
    val m = line[1].toLong()

    val arr = Array(n) { readLine().toLong() }.sortedArray()

    var low = 0L
    var high = arr.maxOrNull()!! * m
    var answer = Long.MAX_VALUE

    while (low <= high) {
        val mid = (low + high) / 2

        var sum = 0L
        for (i in 0 until n) {
            sum += mid / arr[i]
            if (sum >= m) break
        }

        if (sum >= m) {
            high = mid - 1
            answer = min(mid, answer)
        } else {
            low = mid + 1
        }
    }
    println(answer)
}