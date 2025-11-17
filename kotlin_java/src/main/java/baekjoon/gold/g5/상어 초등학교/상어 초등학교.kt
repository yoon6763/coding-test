package baekjoon.gold.g5.`상어 초등학교`

import java.util.StringTokenizer
import kotlin.math.pow

data class Node(val x: Int, val y: Int, val emptyCount: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val n = readLine().toInt()
    val map = Array(n) { IntArray(n) }

    val likeGraph = Array(n * n + 1) { mutableListOf<Int>() }

    repeat(n * n) {
        val st = StringTokenizer(readLine())
        val studentNumber = st.nextToken().toInt()
        val like = IntArray(4) { st.nextToken().toInt() }
        likeGraph[studentNumber].addAll(like.toList())

        var maxLikeCount = 0
        val candidateNodes = mutableListOf<Node>()

        for (i in 0..<n) {
            for (j in 0..<n) {
                if (map[i][j] != 0) continue
                var nowLikeCount = 0
                var emptyCount = 0

                for (k in 0..<4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue
                    if (map[nx][ny] in like) nowLikeCount++
                    if (map[nx][ny] == 0) emptyCount++
                }

                if (nowLikeCount > maxLikeCount) {
                    maxLikeCount = nowLikeCount
                    candidateNodes.clear()
                    candidateNodes.add(Node(i, j, emptyCount))
                } else if (nowLikeCount == maxLikeCount) {
                    candidateNodes.add(Node(i, j, emptyCount))
                }
            }
        }

        candidateNodes.sortWith(compareBy({ -it.emptyCount }, { it.x }, { it.y }))
        map[candidateNodes[0].x][candidateNodes[0].y] = studentNumber
    }

    var answer = 0
    for (i in 0..<n) {
        for (j in 0..<n) {
            val studentNumber = map[i][j]
            val like = likeGraph[studentNumber]
            var likeCount = 0
            for (k in 0..<4) {
                val nx = i + dx[k]
                val ny = j + dy[k]
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue
                if (map[nx][ny] in like) likeCount++
            }
            if (likeCount != 0) answer += 10.0.pow(likeCount - 1).toInt()
        }
    }
    println(answer)
}