package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine(), " ")
    val arr = Array(n + 1) { 1 }
    val rightDP = Array(n + 1) { 1 }
    val leftDP = Array(n + 1) { 1 }

    for (i in 1..n) {
        arr[i] = st.nextToken().toInt()
    }

    for (i in 1..n) {
        for (j in 1 until i) {
            if (arr[i] > arr[j]) leftDP[i] = max(leftDP[i], leftDP[j] + 1)
        }
    }

    for (i in n downTo 1    ) {
        for (j in n downTo i + 1) {
            if (arr[i] > arr[j]) rightDP[i] = max(rightDP[i], rightDP[j] + 1)
        }
    }

    var max = 0

    for (i in 1..n) {
        max = max(max, rightDP[i] + leftDP[i])
    }
    println(max - 1)
}
/*
10
1 5 2 1 4 3 4 5 2 1
 */