package baekjoon.silver.s1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    class Node(val x: Int, val y: Int)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    lateinit var start: Node
    val notArrival = ArrayList<Node>()

    val map = Array(n) { x ->
        val st = StringTokenizer(readLine())
        Array(m) { y ->
            val num = st.nextToken().toInt()
            if (num == 2) {
                start = Node(x, y)
            } else if (num == 0) {
                notArrival.add(Node(x, y))
            }
            num
        }
    }

    val visited = Array(n) { Array(m) { -1 } }

    visited[start.x][start.y] = 0
    val q = LinkedList<Node>() as Queue<Node>
    q.offer(start)

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] != -1 || map[nx][ny] == 0) continue
            visited[nx][ny] = visited[target.x][target.y] + 1
            q.offer(Node(nx, ny))
        }
    }

    notArrival.forEach { visited[it.x][it.y] = 0 }

    val sb = StringBuilder()
    visited.forEach {
        it.forEach {
            sb.append(it).append(" ")
        }
        sb.append("\n")
    }

    print(sb)
}