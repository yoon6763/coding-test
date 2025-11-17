package baekjoon.bronze.b3

import java.util.StringTokenizer

fun main() = repeat(readln().toInt()) {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val arr = IntArray(n) { st.nextToken().toInt() }
    val evenCount = arr.filter { it % 2 == 0 }.sum()
    val oddCount = arr.filter { it % 2 == 1 }.sum()
    println(if (evenCount > oddCount) "EVEN" else if (evenCount < oddCount) "ODD" else "TIE")
}