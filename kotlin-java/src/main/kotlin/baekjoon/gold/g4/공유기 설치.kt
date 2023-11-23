package baekjoon.gold.g4

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine().split(" ").map { it.toInt() } // 집 개수, 공유기 수
    val arr = Array(n) { readLine().toLong() }
    arr.sort()

    var left = 1L
    var right = arr[n - 1] - arr[0]

    var maxDistance = 0L

    // 이진 탐색
    while (left <= right) {
        val targetDistance = (left + right) / 2

        // 설치할 수 있는 공유기 개수 계산
        var installableCnt = 1
        var prev = arr[0]

        for (i in 1 until n) {
            if (arr[i] - prev >= targetDistance) {
                installableCnt++
                prev = arr[i]
            }
        }

        if (installableCnt >= c) {
            // 설치한 공유기가 설치해야 하는 공유기보다 많을 때
            left = targetDistance + 1
            maxDistance = max(maxDistance, targetDistance)
        } else {
            // 설치한 공유기가 설치해야 하는 공유기보다 적을 때
            right = targetDistance - 1
        }
    }

    println(maxDistance)
}