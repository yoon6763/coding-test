package baekjoon.silver.s1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    val (n, m) = readLine().split(" ").map { it.toInt() }

    val st = StringTokenizer(readLine())
    val minute = Array(n) { st.nextToken().toInt() }


    var left = minute.maxOrNull()!!
    var right = minute.sum()

    while (left <= right) {
        val middle = (left + right) / 2

        var blueRayCnt = 0
        var blueRaySum = 0

        for (i in 0 until n) {
            if (blueRaySum + minute[i] <= middle) {
                blueRaySum += minute[i]
            } else {
                blueRaySum = minute[i]
                blueRayCnt++
            }
        }

        if (blueRaySum != 0) blueRayCnt++

        if (m < blueRayCnt) {
            left = middle + 1
        } else {
            right = middle - 1
        }
    }

    println(left)
}