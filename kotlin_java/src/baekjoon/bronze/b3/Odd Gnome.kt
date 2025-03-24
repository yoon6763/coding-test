package baekjoon.bronze.b3

import java.util.StringTokenizer

fun main() {
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val arr = Array(n) { st.nextToken().toInt() }
        for (i in 1..<(n - 1)) {
            if (arr[i] != arr[i - 1] + 1) {
                println(i + 1)
                break
            }
        }
    }
}
