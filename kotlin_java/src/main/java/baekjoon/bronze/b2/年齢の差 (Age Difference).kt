package baekjoon.bronze.b2

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = LongArray(n) { st.nextToken().toLong() }
    val max = arr.max()
    val min = arr.min()

    for (i in 0..<n) {
        println(maxOf(abs(max - arr[i]), abs(min - arr[i])))
    }
}