package baekjoon.silver.s4

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val st = StringTokenizer(readLine())

    val arr = Array(n) { 0 }
    repeat(n) {
        arr[it] = st.nextToken().toInt()
    }

    arr.sort()

    var cnt = 0
    var l = 0
    var r = n - 1

    while (l < r) {
        if (arr[l] + arr[r] == m) {
            cnt++
            r--
        } else if (arr[l] + arr[r] > m) {
            r--
        } else {
            l++
        }
    }
    println(cnt)
}