package baekjoon.bronze.b2

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        var n = st.nextToken().toDouble()
        while (st.hasMoreTokens()) {
            val cmd = st.nextToken()
            when (cmd) {
                "@" -> n *= 3
                "%" -> n += 5
                "#" -> n -= 7
            }
        }
        println("%.2f".format(n))
    }
}