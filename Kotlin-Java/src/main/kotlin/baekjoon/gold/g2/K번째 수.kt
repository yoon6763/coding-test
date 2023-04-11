package baekjoon.gold.g2

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toLong()
    val k = readLine().toInt()

    var left = 1L
    var right = k.toLong()
    var result = 0L

    while (left <= right) {
        val middle = (left + right) / 2
        var cnt = 0L

        for(i in 1 .. n) {
            cnt += min(middle / i, n)
        }

        if(cnt < k ) {
            left = middle + 1
        } else {
            result =  middle
            right = middle - 1
        }
    }

    println(result)
}