package baekjoon.gold.g3.`모양 만들기`

import java.util.StringTokenizer

lateinit var map: Array<IntArray>
lateinit var visited: Array<IntArray>
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var size = 0
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(m) { st.nextToken().toInt() }
    }
    visited = Array(n) { IntArray(m) }

    var groupIndex = 1
    val groupSize = ArrayList<Int>().apply { add(0) }

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] != 1 || visited[i][j] != 0) continue
            size = 0
            dfs(i, j, groupIndex)
            groupIndex++
            groupSize.add(size)
        }
    }

    var answer = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] != 0) continue
            val set = HashSet<Int>()
            for (k in 0..<4) {
                val nx = i + dx[k]
                val ny = j + dy[k]
                if (nx !in 0..<n || ny !in 0..<m) continue
                set.add(visited[nx][ny])
            }
            answer = maxOf(answer, 1 + set.sumOf { groupSize[it] })
        }
    }

    println(answer)
}

fun dfs(x: Int, y: Int, groupIndex: Int) {
    visited[x][y] = groupIndex
    size++

    for (i in 0..<4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == 0 || visited[nx][ny] != 0) continue
        dfs(nx, ny, groupIndex)
    }
}
