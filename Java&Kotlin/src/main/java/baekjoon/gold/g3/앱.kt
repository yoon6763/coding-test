package baekjoon.gold.g3

import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val memory = Array(n + 1) { 0 }
    val deMemory = Array(n + 1) { 0 }
    val dp = Array(n + 1) { Array(10001) { 0 } }
    var min = Int.MAX_VALUE

    var st = StringTokenizer(readLine())
    for (i in 1..n) {
        memory[i] = st.nextToken().toInt()
    }

    st = StringTokenizer(readLine())
    for (i in 1..n) {
        deMemory[i] = st.nextToken().toInt()
    }

    for (i in 1..n) {
        for (j in 0..10000) {
            if (deMemory[i] <= j) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - deMemory[i]] + memory[i])
            } else {
                dp[i][j] = dp[i - 1][j]
            }
            if (dp[i][j] >= m) min = min(min, j)
        }
    }
    println(min)
}