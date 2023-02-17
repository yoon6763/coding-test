package baekjoon.silver.s4

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())
    val arr = Array(n) { st.nextToken().toInt() }

    var left = 0
    var right = 1
    var sum = arr[0]
    var cnt = 0

    while (true) {
        if (sum == m) {
            cnt++
            sum -= arr[left++]
        } else if (sum < m) {
            if (right == n) break
            sum += arr[right++]
        } else {
            sum -= arr[left++]
        }
    }

    println(cnt)
}