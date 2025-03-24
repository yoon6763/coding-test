package baekjoon.bronze.b4

import java.util.*

fun main() {
    val st = StringTokenizer(readln().trim())
    val a = st.nextToken().toInt()
    println(List(4) { st.nextToken().toInt() }.count { a - 1000 <= it })
}
