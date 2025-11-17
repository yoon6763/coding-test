package programmers.lv2.거리두기_확인하기

fun solution(places: Array<Array<String>>): IntArray {
    val answer = IntArray(places.size) { 1 }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    places.forEachIndexed { index, strings ->
        for (i in 0 until 5) {
            for (j in 0 until 5) {
                if (strings[i][j] == 'P') {
                    val visited = Array(5) { IntArray(5) { 0 } }
                    val q = mutableListOf<Pair<Int, Int>>()
                    q.add(Pair(i, j))
                    visited[i][j] = 1

                    while (q.isNotEmpty()) {
                        val cur = q.removeAt(0)

                        for(k in 0 until 4) {
                            val nx = cur.first + dx[k]
                            val ny = cur.second + dy[k]

                            if (nx in 0 until 5 && ny in 0 until 5 && visited[nx][ny] == 0) {
                                if (strings[nx][ny] == 'P') {
                                    answer[index] = 0
                                    return@forEachIndexed
                                } else if (strings[nx][ny] == 'O') {
                                    visited[nx][ny] = visited[cur.first][cur.second] + 1
                                    if (visited[nx][ny] <= 2) q.add(Pair(nx, ny))
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    return answer
}