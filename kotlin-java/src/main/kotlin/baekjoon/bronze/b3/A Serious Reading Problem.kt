package baekjoon.bronze.b3

import java.util.*
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val st = StringTokenizer(readLine())
        val (a, b, c, d) = List(4) { st.nextToken().toDouble() }
        if (a == 0.0 && b == 0.0 && c == 0.0 && d == 0.0) break
        sb.appendLine(a.pow(b).pow(c).pow(d).toLong())
    }
    print(sb)
}