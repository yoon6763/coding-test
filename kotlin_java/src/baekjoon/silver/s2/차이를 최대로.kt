package baekjoon.silver.s2.차이를최대로

import java.util.*
import kotlin.math.abs

var n = 0
var max = 0
lateinit var arr: Array<Int>
lateinit var visited: Array<Boolean>
lateinit var arrIdx: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    val st = StringTokenizer(readLine())
    arr = Array(n) { st.nextToken().toInt() }
    visited = Array(n) { false }
    arrIdx = Array(n) { -1 }

    backTracking(0)
    println(max)
}

fun backTracking(idx: Int) {
    if (idx == n) {
        var sum = 0
        for (i in 0 until n - 1) {
            sum += abs(arr[arrIdx[i]] - arr[arrIdx[i + 1]])
        }
        max = maxOf(max, sum)
        return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            arrIdx[idx] = i
            backTracking(idx + 1)
            visited[i] = false
        }
    }
}
