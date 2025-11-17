package baekjoon.gold.g1.`달이 차오른다, 가자`

import java.util.*


data class Node(var x: Int, var y: Int, var cnt: Int = 0, var key: Int = 0)

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    val n = nm[0]
    val m = nm[1]

    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    val start = Node(-1, -1)

    val map = Array(n) { x ->
        val line = readLine().toCharArray()
        for (y in line.indices) {
            if (line[y] == '0') {
                start.x = x
                start.y = y
            }
        }
        line
    }

    val visited = Array(64) { Array(n) { Array(m) { false } } }
    val q = LinkedList<Node>() as Queue<Node>
    visited[0][start.x][start.y] = true
    q.offer(Node(start.x, start.y, 0, 0))

    while (q.isNotEmpty()) {
        val (x, y, cnt, key) = q.poll()

        if (map[x][y] == '1') {
            println(cnt)
            return
        }

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == '#' || visited[key][nx][ny]) continue

            if (map[nx][ny] in 'a'..'f') {
                val nk = 1 shl map[nx][ny] - 'a' or key
                if (visited[nk][nx][ny]) continue
                q.offer(Node(nx, ny, cnt + 1, nk))
            } else if (map[nx][ny] in 'A'..'F') {
                if (key and (1 shl map[nx][ny] - 'A') == 0) continue
                q.offer(Node(nx, ny, cnt + 1, key))
            } else {
                q.offer(Node(nx, ny, cnt + 1, key))
            }
            visited[key][nx][ny] = true
        }
    }

    println(-1)
}

/*
7 8
a#c#eF.1
.#.#.#..
.#B#D###
0....F.1
C#E#A###
.#.#.#..
d#f#bF.1
 */