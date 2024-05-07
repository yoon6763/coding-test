package baekjoon.bronze.b3

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        var (now, target) = IntArray(2) { st.nextToken().toInt() }
        var count = 0
        while (now < target) {
            now *= 2
            count++
        }
        sb.appendLine(count)
    }
    print(sb)
}