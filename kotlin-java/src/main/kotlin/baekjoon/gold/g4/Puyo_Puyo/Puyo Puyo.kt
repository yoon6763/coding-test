package baekjoon.gold.g4.Puyo_Puyo

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)
val n = 12
val m = 6

fun main() = with(System.`in`.bufferedReader()) {
    val map = Array(n) { readLine().toCharArray() }
    var ans = 0

    while (true) {
        var isPuyoRemoved = false
        val visited = Array(n) { BooleanArray(m) }

        for (i in 0..<n) {
            for (j in 0..<m) {
                if (map[i][j] == '.' || visited[i][j]) continue
                val removeList = dfs(i, j, visited, map, ArrayList())
                if (removeList.size >= 4) {
                    isPuyoRemoved = true
                    for (node in removeList) {
                        map[node.x][node.y] = '.'
                    }
                }
            }
        }

        if (!isPuyoRemoved) break
        ans++

        puyoDown(map)
    }

    println(ans)
}

fun dfs(
    x: Int,
    y: Int,
    visited: Array<BooleanArray>,
    map: Array<CharArray>,
    removeList: ArrayList<Node>
): ArrayList<Node> {
    visited[x][y] = true
    removeList.add(Node(x, y))

    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] || map[nx][ny] != map[x][y]) continue
        dfs(nx, ny, visited, map, removeList)
    }

    return removeList
}

fun puyoDown(map: Array<CharArray>) {
    for (col in 0..<m) {
        val queue = ArrayDeque<Char>()

        for (row in n - 1 downTo 0) {
            if (map[row][col] == '.') continue
            queue.add(map[row][col])
            map[row][col] = '.'
        }

        var idx = n - 1
        while (queue.isNotEmpty()) {
            map[idx--][col] = queue.removeFirst()
        }
    }
}
