package baekjoon.bronze.b4

import java.util.StringTokenizer

fun main() {
    val bw = System.out.bufferedWriter()
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        bw.write("${a + b}\n")
    }
    bw.flush()
}