package baekjoon.bronze.b1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        readLine()
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val iq = LongArray(n)

        var c = 0L
        var e = 0L

        var st = StringTokenizer(readLine())
        for (i in 0..<n) {
            iq[i] = st.nextToken().toLong()
            c += iq[i]
        }
        st = StringTokenizer(readLine())
        for (i in 0..<m) {
            e += st.nextToken().toLong()
        }

        var answer = 0

        for (i in 0..<n) {
            if (c > iq[i] * n && e < iq[i] * m) answer++
        }

        println(answer)
    }
}
