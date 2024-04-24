package baekjoon.bronze.b4

import java.util.*

fun main() {
    val st = StringTokenizer(readln())
    print(maxOf(0, -(List(4) { st.nextToken().toInt() }.sum() - st.nextToken().toInt() * 4)))
}