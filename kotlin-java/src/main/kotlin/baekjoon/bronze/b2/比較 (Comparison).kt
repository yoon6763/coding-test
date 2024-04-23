package baekjoon.bronze.b2

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var st = StringTokenizer(readln())
    val arr = IntArray(n) { st.nextToken().toInt() }
    st = StringTokenizer(readln())
    val arr2 = IntArray(m) { st.nextToken().toInt() }

    var cnt = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i] <= arr2[j]) cnt++
        }
    }
    println(cnt)
}