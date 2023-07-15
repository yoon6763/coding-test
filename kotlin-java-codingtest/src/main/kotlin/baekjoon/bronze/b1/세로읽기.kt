package baekjoon.bronze.b1

import java.lang.StringBuilder

fun main() {
    val arr = Array(5) { readln() }
    val sb = StringBuilder()
    for (i in 0 until arr.maxOf { it.length }) for (j in 0 until 5) if (arr[j].length > i) sb.append(arr[j][i])
    println(sb)
}