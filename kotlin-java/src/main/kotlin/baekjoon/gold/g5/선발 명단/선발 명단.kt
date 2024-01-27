package baekjoon.gold.g5.`선발 명단`

import java.util.StringTokenizer

lateinit var stats: Array<IntArray>
lateinit var visited: BooleanArray

private const val PLAYER_MAX_POSITION = 5

var ans = 0

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    visited = BooleanArray(11)

    repeat(readLine().toInt()) {
        visited.fill(false)
        ans = 0

        stats = Array(11) {
            val st = StringTokenizer(readLine())
            IntArray(11) { st.nextToken().toInt() }
        }

        dfs(0, 0, 0)
        sb.appendLine(ans)
    }

    print(sb)
}

fun dfs(idx: Int, statSum: Int, depth: Int) {
    if (depth == 11) {
        ans = maxOf(ans, statSum)
        return
    }

    for (i in idx..<11) {
        var positionCount = 0

        for (j in 0..<11) {
            if (stats[i][j] == 0 || visited[j]) continue
            positionCount++

            visited[j] = true
            dfs(i + 1, statSum + stats[i][j], depth + 1)
            visited[j] = false

            if (positionCount >= PLAYER_MAX_POSITION) break
        }
    }
}