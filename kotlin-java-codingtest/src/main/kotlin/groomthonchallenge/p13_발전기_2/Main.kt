package groomthonchallenge.p13_발전기_2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().split(" ").map { it.toInt() } }
    val visited = Array(n) { BooleanArray(n) }

    val groupCnt = Array(31) { 0 }

    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    val q = ArrayDeque<Pair<Int, Int>>()

    repeat(n) { x ->
        repeat(n) { y ->
            if (!visited[x][y]) {
                var cnt = 1
                visited[x][y] = true
                q.add(Pair(x, y))

                while (q.isNotEmpty()) {
                    val cur = q.removeFirst()

                    for (i in 0 until 4) {
                        val nx = cur.first + dx[i]
                        val ny = cur.second + dy[i]

                        if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] || map[nx][ny] != map[x][y]) continue
                        cnt++
                        visited[nx][ny] = true
                        q.add(Pair(nx, ny))
                    }
                }

                if (cnt >= k) {
                    groupCnt[map[x][y]]++
                }
            }
        }
    }

    println(groupCnt.indexOfLast { it == groupCnt.max() })
}