package baekjoon.gold.g2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine(), " ")
    val arr = Array(n + 1) { 0 }
    val dp = Array(n + 1) { 0 }

    dp[1] = 1

    for (i in 1..n) {
        arr[i] = st.nextToken().toInt()
    }

    for (i in 2..n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j] && dp[i] <= dp[j]) dp[i] = dp[j] + 1
        }
    }
    val stack = Stack<Int>()
    var len = dp.maxOrNull()!!

    for(i in n downTo 1) {
        if(len == dp[i]) {
            stack.add(arr[i])
            len--
        }
    }

    println(dp.maxOrNull()!!)
    while (stack.isNotEmpty()) {
        print("${stack.pop()} ")
    }
}