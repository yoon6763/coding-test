package baekjoon.silver.s5

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val list = ArrayList<String>()
    var str = readLine()

    while (str != null) {
        val st = StringTokenizer(str)
        while (st.hasMoreTokens()) list.add(st.nextToken())
        str = readLine()
    }
    list.removeAt(0)

    val sb = StringBuilder()
    list.map { it.reversed().toLong() }.sorted().forEach { sb.append(it).append("\n") }
    print(sb)
}