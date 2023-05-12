package baekjoon.gold.g2

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val div = 1000000007

    val st = StringTokenizer(readLine())
    val arr = Array(n + 1) { 0L }
    val pow = Array(n + 1) { 0L }
    pow[0] = 1

    for (i in 1..n) {
        arr[i] = st.nextToken().toLong()
        pow[i] = (pow[i - 1] * 2) % div
    }

    arr.sort()

    var result = 0L

    for (i in 1..n) {
        result += (pow[i - 1] - pow[n - i]) * arr[i]
        result %= div
    }
    println(result)
}
