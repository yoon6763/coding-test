package baekjoon.silver.s5

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    StringTokenizer(readLine()).let { st ->
        val arr = Array(n) { st.nextToken().toInt() }
        arr.sort()
        println(arr[k - 1])
    }
}