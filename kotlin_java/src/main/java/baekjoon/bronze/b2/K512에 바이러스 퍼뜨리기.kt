package baekjoon.bronze.b2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var (n, q) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    val computer = BooleanArray(n + 1) { false }

    repeat(q) {
        val st = StringTokenizer(readLine())
        when (st.nextToken().toInt()) {
            1 -> {
                val x = st.nextToken().toInt()
                if (!computer[x]) {
                    computer[x] = true
                    n--
                }
            }

            2 -> {
                val x = st.nextToken().toInt()
                if (computer[x]) {
                    computer[x] = false
                    n++
                }
            }

            3 -> sb.appendLine(n)
        }
    }

    print(sb)
}