package baekjoon.silver.s5

import java.lang.StringBuilder
import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val list = Array(n) { st.nextToken().toInt() }.sortedDescending()

        var largestGap = 0
        for (i in 1 until n) largestGap = maxOf(largestGap, list[i - 1] - list[i])

        sb.append("Class ${it + 1}").append("\n")
        sb.append("Max ${list.first()}, Min ${list.last()}, Largest gap $largestGap").append("\n")
    }
    print(sb)
}