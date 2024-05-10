package baekjoon.bronze.b2

import java.util.*

fun main() {
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        var max = 0
        var cnt = 0

        repeat(n) {
            val o = st.nextToken()
            if (o == "X") {
                cnt++
                max = maxOf(max, cnt)
            } else {
                cnt = 0
            }
        }
        println("The longest contiguous subsequence of X's is of length $max")
    }
}