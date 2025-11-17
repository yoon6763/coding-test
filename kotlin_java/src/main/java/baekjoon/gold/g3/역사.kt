package baekjoon.gold.g3

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val arr = Array(n + 1) { Array(n + 1) { 987654321 } }

    repeat(k) {
        val st = StringTokenizer(readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        arr[from][to] = 1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (arr[i][j] > arr[i][k] + arr[k][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j]
                }
            }
        }
    }

    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()

        if (arr[from][to] == arr[to][from]) sb.append("0")
        else if (arr[from][to] > arr[to][from]) sb.append("1")
        else sb.append("-1")
        sb.append("\n")
    }

    print(sb)
}