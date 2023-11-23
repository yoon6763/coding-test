package baekjoon.gold.g3

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt() // 물건의 개수
    val m = readLine().toInt() // 순서 쌍의 개수

    val weight = Array(n + 1) { Array(n + 1) { 0 } }

    for (i in 1..n) {
        weight[i][i] = 0
    }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val o1 = st.nextToken().toInt()
        val o2 = st.nextToken().toInt()

        weight[o1][o2] = 1
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

    val sb = StringBuilder()

    for (i in 1..n) {
        var cnt = 0

        for (j in 1..n) {
            if (i != j && weight[i][j] == 0 && weight[j][i] == 0) cnt++
        }
        sb.append(cnt).append("\n")
    }

    print(sb)
}