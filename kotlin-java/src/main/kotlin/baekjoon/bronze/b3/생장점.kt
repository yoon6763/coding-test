package baekjoon.bronze.b3

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val line = readLine()
        if (line == "0") {
            print(sb)
            break
        }

        val st = StringTokenizer(line)
        val age = st.nextToken().toInt()

        var count = 1

        repeat(age) {
            val (newWood, removed) = st.nextToken().toInt() to st.nextToken().toInt()
            count *= newWood
            count -= removed
        }

        sb.appendLine(count)
    }
}