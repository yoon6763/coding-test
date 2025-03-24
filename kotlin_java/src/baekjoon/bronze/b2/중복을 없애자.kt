package baekjoon.bronze.b2

import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    while (true) {
        val st = StringTokenizer(readln())
        if (st.nextToken().toInt() == 0) break
        var pre = st.nextToken().toInt()
        sb.append("$pre ")
        while (st.hasMoreTokens()) {
            val cur = st.nextToken().toInt()
            if (pre != cur) {
                sb.append("$cur ")
                pre = cur
            }
        }
        sb.append("$\n")
    }
    print(sb)
}