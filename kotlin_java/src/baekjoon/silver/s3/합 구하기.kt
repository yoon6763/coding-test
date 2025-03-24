package baekjoon.silver.s3

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val accSum = IntArray(n + 1) { 0 }
    val st = StringTokenizer(readLine())

    for (i in 0 until n) {
        accSum[i] = st.nextToken().toInt()
        if (i > 0) accSum[i] += accSum[i - 1]
    }

    val sb = StringBuilder()

    val m = readLine().toInt()
    repeat(m) {
        val st = StringTokenizer(readLine())
        val (s, e) = st.nextToken().toInt() - 1 to st.nextToken().toInt() - 1
        sb.appendLine(accSum[e] - if (s > 0) accSum[s - 1] else 0)
    }
    print(sb)
}