package baekjoon.silver.s4

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val arr = Array(n) { Pair(it, st.nextToken().toInt()) }.sortedBy { it.second }
    val answer = IntArray(n)
    for (i in arr.indices) answer[arr[i].first] = i
    println(answer.joinToString(" "))
}