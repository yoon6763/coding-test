package baekjoon.bronze.b1

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val arr = Array(10) { 0 }
        val st = StringTokenizer(readLine())
        repeat(10) {
            arr[it] = st.nextToken().toInt()
        }
        arr.sort()
        sb.append("${arr[7]}\n")
    }
    print(sb)
}