package baekjoon.gold.g3.`Baaaaaaaaaduk2 (Easy)`

import java.util.StringTokenizer

data class Node(val x: Int, val y: Int)

lateinit var map: Array<IntArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, -1, 0, 1)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]
    visited = Array(n) { BooleanArray(m) }

    val blankPoints = ArrayList<Node>()

    map = Array(n) { x ->
        val st = StringTokenizer(readLine())
        IntArray(m) { y ->
            val num = st.nextToken().toInt()
            if (num == 0) {
                blankPoints.add(Node(x, y))
            }
            num
        }
    }

    var answer = 0

    for (selectPos1 in 0..<blankPoints.size) {
        for (selectPos2 in selectPos1 + 1..<blankPoints.size) {
            visited.forEach { it.fill(false) }
            val (select1X, select1Y) = blankPoints[selectPos1]
            val (select2X, select2Y) = blankPoints[selectPos2]
            map[select1X][select1Y] = 1
            map[select2X][select2Y] = 1

            var size = 0
            for (x in 0..<n) {
                for (y in 0..<m) {
                    if (map[x][y] == 2 && !visited[x][y]) {
                        size += bfs(x, y)
                    }
                }
            }
            map[select1X][select1Y] = 0
            map[select2X][select2Y] = 0

            answer = maxOf(answer, size)
        }
    }

    println(answer)
}

fun bfs(x: Int, y: Int): Int {
    val q = ArrayDeque<Node>()
    visited[x][y] = true
    q.addFirst(Node(x, y))
    var size = 1

    var flag = false

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0..<4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] || map[nx][ny] == 1) continue
            if (map[nx][ny] == 0) {
                flag = true
            }
            visited[nx][ny] = true
            q.addLast(Node(nx, ny))
            size++
        }
    }
    return if (flag) 0 else size
}