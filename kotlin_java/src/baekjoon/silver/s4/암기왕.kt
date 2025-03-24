package baekjoon.silver.s4

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        var n = readLine().toInt()
        var st = StringTokenizer(readLine())
        val set = mutableSetOf<Int>()
        repeat(n) {
            set.add(st.nextToken().toInt())
        }

        n = readLine().toInt()
        st = StringTokenizer(readLine())
        repeat(n) {
            sb.appendLine(if (set.contains(st.nextToken().toInt())) 1 else 0)
        }
    }
    print(sb)
}