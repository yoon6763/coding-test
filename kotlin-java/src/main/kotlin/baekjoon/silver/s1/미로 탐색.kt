package baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Node(val x: Int, val y: Int)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    val n = nm[0].toInt()
    val m = nm[1].toInt()

    val map = Array(n) { Array(m) { 0 } }

    repeat(n) { x ->
        val line = br.readLine()
        repeat(m) { y ->
            map[x][y] = line[y] - '0'
        }
    }

    bfs(n, m, map)
}

fun bfs(n: Int, m: Int, map: Array<Array<Int>>) {
    // 1 - 이동가능, 0 - 벽
    val q: Queue<Node> = LinkedList()
    val visited = Array(n) { Array(m) { 1 } }

    q.offer(Node(0, 0))
    visited[0][0] = 1

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 0 || visited[nx][ny] != 1)
                continue

            q.offer(Node(nx, ny))
            visited[nx][ny] = visited[target.x][target.y] + 1

            if (nx == n - 1 && ny == m - 1) {
                println(visited[nx][ny])
                break
            }
        }
    }
}

/*
4 6
110110
110110
111111
111101

9
 */


/*
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111

13
 */