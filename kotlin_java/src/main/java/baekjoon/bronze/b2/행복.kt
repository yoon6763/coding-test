package baekjoon.bronze.b2

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val arr = IntArray(n) { st.nextToken().toInt() }
    println(arr.maxOrNull()!! - arr.minOrNull()!!)
}