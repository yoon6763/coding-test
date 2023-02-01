package baekjoon.silver.s3

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = Array(n) { st.nextToken().toInt() }
    val x = readLine().toInt()

    arr.sort()

    var t = n - 1
    var b = 0
    var cnt = 0

    while (b < t) {
        val sum = arr[b] + arr[t]

        if (sum == x) {
            cnt++
            t--
        } else if (sum < x) {
            b++
        } else {
            // sum > x
            t--
        }
    }

    println(cnt)
}