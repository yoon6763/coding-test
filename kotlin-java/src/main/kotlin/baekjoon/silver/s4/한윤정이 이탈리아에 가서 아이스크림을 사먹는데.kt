package baekjoon.silver.s4

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val notAble = Array(n + 1) { Array(n + 1) { false } }
    repeat(m) {
        val st = StringTokenizer(readLine())
        val (a, b) = st.nextToken().toInt() to st.nextToken().toInt()
        notAble[a][b] = true
        notAble[b][a] = true
    }

    var ans = 0
    for (i in 1..n) {
        for (j in i + 1..n) {
            if (notAble[i][j] || notAble[j][i]) continue
            for (k in j + 1..n) {
                if (notAble[i][j] || notAble[i][k] || notAble[j][k]) continue
                ans++
            }
        }
    }

    println(ans)
}