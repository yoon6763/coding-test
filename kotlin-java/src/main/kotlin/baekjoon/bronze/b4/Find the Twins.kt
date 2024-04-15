package baekjoon.bronze.b4

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val arr = Array(10) { st.nextToken().toInt() }
        sb.appendLine(arr.joinToString(" "))
        var mack = 18 in arr
        var zack = 17 in arr
        if (mack && zack) sb.appendLine("both")
        else if (mack || zack) sb.appendLine(if (mack) "mack" else "zack")
        else sb.appendLine("none")
        sb.appendLine()
    }
    print(sb.trimEnd())
}