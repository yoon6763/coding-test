package baekjoon.gold.g2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val st = StringTokenizer(br.readLine(), " ")

    val arr = Array(n) { 0 }
    val LIS = Array(n) { 0 }

    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    LIS[0] = arr[0]
    var maxLen = 1

    for (i in 1 until n) {
        val key = arr[i]

        if (LIS[maxLen - 1] < key) {
            LIS[maxLen++] = key
        } else {
            // 이진 탐색
            var l = 0
            var h = maxLen

            while (l < h) {
                val mid = (l + h) / 2

                if(LIS[mid] < key ) l = mid + 1
                else h = mid
            }

            LIS[l] = key
        }

    }
    println(maxLen)
}