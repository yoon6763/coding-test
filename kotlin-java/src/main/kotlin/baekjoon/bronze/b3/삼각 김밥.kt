package baekjoon.bronze.b3

import java.util.*

fun main() {
    var st = StringTokenizer(readln())
    val X = st.nextToken().toDouble()
    val Y = st.nextToken().toDouble()
    var R = (1000 / Y) * X

    repeat(readln().toInt()) {
        st = StringTokenizer(readln())
        val (x, y) = st.nextToken().toDouble() to st.nextToken().toDouble()
        R = minOf(R, (1000 / y) * x)
    }
    println(String.format("%.2f", R))
}
