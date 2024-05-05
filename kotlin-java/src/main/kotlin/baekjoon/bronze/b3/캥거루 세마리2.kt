package baekjoon.bronze.b3

import java.util.*
import kotlin.math.max

fun main() {
    while (true) {
        val st = StringTokenizer(readlnOrNull() ?: break)
        val (A, B, C) = IntArray(3) { st.nextToken().toInt() }
        println(max(B - A, C - B) - 1)
    }
}