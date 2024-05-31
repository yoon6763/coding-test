package baekjoon.bronze.b2

import java.util.*

fun main() {
    val (w, n) = StringTokenizer(readln()).let { it.nextToken() to it.nextToken().toInt() }
    val isHorizontal = w in listOf("R", "L")
    val arr = Array(n) { Array(n) { "" } }

    for (i in 0..<n) {
        val st = StringTokenizer(readln())
        for (j in 0..<n) {
            arr[if (isHorizontal) i else n - i - 1][if (isHorizontal) n - j - 1 else j] =
                when (val tmp = st.nextToken()) {
                    "2" -> "5"
                    "5" -> "2"
                    "1", "8" -> tmp
                    else -> "?"
                }
        }
    }

    println(arr.joinToString("\n") { it.joinToString(" ") })
}