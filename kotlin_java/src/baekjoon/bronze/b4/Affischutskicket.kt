package baekjoon.bronze.b4

import java.util.*

fun main() {
    val st = StringTokenizer(readln())
    val e = 229 * 324 * Integer.parseInt(st.nextToken()) * 2
    val p = 297 * 420 * Integer.parseInt(st.nextToken()) * 2
    val i = 210 * 297 * Integer.parseInt(st.nextToken())
    println((e + p + i) * 0.000001)
}