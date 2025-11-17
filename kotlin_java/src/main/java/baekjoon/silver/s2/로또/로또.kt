package baekjoon.silver.s2.로또

import java.util.*

var n = 0
lateinit var arr: Array<Int>
lateinit var visited: Array<Boolean>
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {

    while (true) {

        val st = StringTokenizer(readLine())
        n = st.nextToken().toInt()

        if (n == 0) break

        arr = Array(n) { st.nextToken().toInt() }
        visited = Array(n) { false }

        backTracking(0, 0)
        sb.append("\n")
    }

    print(sb)
}


fun backTracking(depth: Int, lastIdx: Int) {

    if (depth == 6) {
        for (i in 0 until n) {
            if (visited[i]) {
                sb.append(arr[i]).append(" ")
            }
        }
        sb.append("\n")
    }

    for (i in lastIdx until n) {
        visited[i] = true
        backTracking(depth + 1, i + 1)
        visited[i] = false
    }
}