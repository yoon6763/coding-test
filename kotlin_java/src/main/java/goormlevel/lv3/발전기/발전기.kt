package goormlevel.lv3.`발전기`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n) { readLine().split(" ").map { it.toInt() } }
    var cnt = 0

    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    val q = ArrayDeque<Pair<Int, Int>>()
    val visited = Array(n) { BooleanArray(n) }

    repeat(n) { x ->
        repeat(n) { y ->
            if (!visited[x][y] && map[x][y] == 1) {
                cnt++
                visited[x][y] = true
                q.add(Pair(x, y))

                while (q.isNotEmpty()) {
                    val cur = q.removeFirst()

                    for (i in 0 until 4) {
                        val nx = cur.first + dx[i]
                        val ny = cur.second + dy[i]

                        if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] || map[nx][ny] == 0) continue
                        visited[nx][ny] = true
                        q.add(Pair(nx, ny))
                    }
                }
            }
        }
    }

    println(cnt)
}