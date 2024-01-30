package baekjoon.gold.g4.`키 순서`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    // 학생의 수 n, 키 비교 횟수 m
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val weight = Array(n + 1) { Array(n + 1) { 0 } }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        weight[a][b] = 1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (weight[i][k] == 1 && weight[k][j] == 1) {
                    weight[i][j] = 1
                }
            }
        }
    }

    var ans = 0

    for (i in 1..n) {
        var cnt = 0

        for (j in 1..n) {
            if (weight[i][j] == 1 || weight[j][i] == 1) cnt++
        }
        if (cnt == n - 1) ans++
    }
    println(ans)
}