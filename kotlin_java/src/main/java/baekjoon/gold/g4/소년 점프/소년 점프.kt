package baekjoon.gold.g4.`소년 점프`

import kotlin.system.exitProcess

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().map { it - '0' }.toIntArray() }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val bfs = { sx: Int, sy: Int ->
        val visited = Array(n) { IntArray(m) { -1 } }
        val q = ArrayDeque<Node>()
        q.add(Node(sx, sy))
        visited[sx][sy] = 0

        while (q.isNotEmpty()) {
            val (x, y) = q.removeFirst()

            for (i in 0..<4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] != -1 || map[nx][ny] == 1) continue
                visited[nx][ny] = visited[x][y] + 1
                q.add(Node(nx, ny))
            }
        }

        visited
    }

    val searchMaps = Array(3) { readLine().split(" ").map { it.toInt() - 1 }.let { bfs(it[0], it[1]) } }

    val joinedMap = Array(n) { x ->
        IntArray(m) { y ->
            if (searchMaps.any { it[x][y] == -1 }) -1 else searchMaps.maxOf { it[x][y] }
        }
    }

    val shortest = joinedMap.flatMap { it.toList() }.filter { it != -1 }.minOrNull() ?: run {
        println(-1)
        exitProcess(0)
    }

    println(shortest)
    println(joinedMap.sumOf { it.count { it == shortest } })
}