package baekjoon.gold.g3.`사다리 조작`

import java.util.*

lateinit var connect: Array<BooleanArray>
var verticalLineCount = 0
var horizontalLineCount = 0
var ans = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    // 세로 선 개수, 가로 선 개수, 세로선 마다 가로 선을 놓을 수 있는 개수
    var st = StringTokenizer(readLine())
    verticalLineCount = st.nextToken().toInt() // 세로 선 개수
    val already = st.nextToken().toInt() // 이미 놓여져 있는 가로 선 개수
    horizontalLineCount = st.nextToken().toInt() // 세로 선 마다 가로 선을 놓을 수 있는 개수

    connect = Array(verticalLineCount) { BooleanArray(horizontalLineCount) }

    repeat(already) {
        st = StringTokenizer(readLine())
        val (a, b) = List(2) { st.nextToken().toInt() - 1 } // b ~ b + 1를 a번 점선 위치에서 연결
        connect[b][a] = true
    }

    backTracking(0, 0)
    println(if (ans == Int.MAX_VALUE) -1 else ans)
}

fun backTracking(index: Int, depth: Int) {
    if (depth > 3) return
    startLadder(depth)

    for (i in index..<((verticalLineCount - 1) * (horizontalLineCount))) {
        val curVerticalLine = i / horizontalLineCount
        val curHorizontalLine = i % horizontalLineCount

        if (connect[curVerticalLine][curHorizontalLine] || curVerticalLine < verticalLineCount - 1 && connect[curVerticalLine + 1][curHorizontalLine]
        ) continue

        connect[curVerticalLine][curHorizontalLine] = true
        backTracking(i + 1, depth + 1)
        connect[curVerticalLine][curHorizontalLine] = false
    }
}


fun startLadder(depth: Int) {
    for (start in 0..<verticalLineCount) {
        var cur = start

        for (height in 0..<horizontalLineCount) {
            if (cur != 0 && connect[cur - 1][height]) {
                cur--
            } else if (connect[cur][height]) {
                cur++
            }
        }

        if (start != cur) {
            return
        }
    }

    ans = minOf(ans, depth)
}
