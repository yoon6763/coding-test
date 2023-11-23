package baekjoon.bronze.b3

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    while (true) {
        val str = readLine() ?: break
        val st =StringTokenizer(str)
        st.nextToken()
        while (st.hasMoreTokens()) {
            val num = st.nextToken().toInt()
            max = maxOf(max, num)
            min = minOf(min, num)
        }
    }
    println("$min $max")
}