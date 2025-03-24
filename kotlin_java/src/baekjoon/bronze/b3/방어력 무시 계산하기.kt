package baekjoon.bronze.b3

import java.util.*

fun main() {
    val n = readln().toInt()
    var v = 0.0
    val st = StringTokenizer(readln())

    repeat(n) {
        val cur = st.nextToken().toInt()
        v = cur + v - v * cur / 100
        println(v)
    }
}
