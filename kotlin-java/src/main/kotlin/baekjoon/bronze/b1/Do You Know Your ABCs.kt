package baekjoon.bronze.b1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val arr = IntArray(7) { st.nextToken().toInt() }.sorted()
    val a = arr[0]
    val b = arr[1]
    val abc = arr[6]

    println("$a $b ${abc - a - b}")
}