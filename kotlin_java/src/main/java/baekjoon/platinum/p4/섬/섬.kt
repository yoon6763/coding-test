package baekjoon.platinum.p4.`섬`

import java.util.*

data class Node(val x: Int, val y: Int)

lateinit var visited: Array<BooleanArray>
lateinit var map: Array<IntArray>
val dx = intArrayOf(0, 0, 1, -1, 1, -1, 1, -1)
val dy = intArrayOf(1, -1, 0, 0, 1, 1, -1, -1)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt() + 2
    m = st.nextToken().toInt() + 2

    map = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    val result = mutableListOf<Int>()

    for (i in 1..n - 2) {
        val line = readLine()
        for (j in 1..<m - 1) {
            map[i][j] = if (line[j - 1] == 'x') 1 else 0
        }
    }

    dfs(setOf(Node(0, 0)), result)

    result.removeLast()
    println(if (result.isNotEmpty()) result.joinToString(" ") else -1)
}

fun dfs(sea: Set<Node>, result: MutableList<Int>): Int {
    val island = mutableSetOf<Node>()
    var h = 0

    sea.forEach { (x, y) ->
        if (visited[x][y]) return@forEach
        island.addAll(bfs(x, y, 4, 0))
    }

    island.forEach { (x, y) ->
        if (visited[x][y]) return@forEach
        h = maxOf(h, dfs(bfs(x, y, 8, 1), result) + 1)
    }

    if (result.size == h) {
        result.add(0)
    }

    result[h]++
    return h
}

fun bfs(x: Int, y: Int, d: Int, type: Int): Set<Node> {
    val queue = LinkedList<Node>() as Queue<Node>
    val s = mutableSetOf<Node>()
    queue.add(Node(x, y))

    while (queue.isNotEmpty()) {
        val (cx, cy) = queue.poll()

        if (visited[cx][cy]) continue
        visited[cx][cy] = true

        for (i in 0..<d) {
            val nx = cx + dy[i]
            val ny = cy + dx[i]

            if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny]) continue

            if (map[nx][ny] == type) queue.add(Node(nx, ny))
            else s.add(Node(nx, ny))
        }
    }

    return s
}