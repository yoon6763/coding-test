package baekjoon.bronze.b3

import java.util.StringTokenizer

fun main() = repeat(readln().toInt()) {
    val st = StringTokenizer(readln())
    val (x1, y1, f1) = IntArray(3) { st.nextToken().toInt() }
    val (x2, y2, f2) = IntArray(3) { st.nextToken().toInt() }
    println(kotlin.math.abs(x1 - x2) + kotlin.math.abs(y1 - y2) + f1 + f2)
}