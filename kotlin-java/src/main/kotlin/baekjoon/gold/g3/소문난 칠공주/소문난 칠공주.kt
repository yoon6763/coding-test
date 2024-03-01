package baekjoon.gold.g3.`소문난 칠공주`
import java.util.*

data class Node(val x: Int, val y: Int)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

lateinit var map: Array<CharArray>
val visited = Array(25) { false }
var result = 0

fun main() = with(System.`in`.bufferedReader()) {
    map = Array(5) { readLine().toCharArray() }
    selectSeven(0, 0, 0)
    println(result)
}

fun selectSeven(idx: Int, cnt: Int, scnt: Int) {
    if (cnt == 7) {
        if (scnt >= 4 && bfs()) result++
        return
    }

    for (i in idx until 25) {
        val x = i / 5
        val y = i % 5
        visited[i] = true
        selectSeven(i + 1, cnt + 1, scnt + if (map[x][y] == 'S') 1 else 0)
        visited[i] = false
    }
}

fun bfs(): Boolean {

    val q = LinkedList<Node>() as Queue<Node>
    for (i in 0 until 25) {
        if (visited[i]) {
            q.offer(Node(i / 5, i % 5))
            break
        }
    }

    val bfsVisited = Array(5) { BooleanArray(5) { false } }
    bfsVisited[q.peek().x][q.peek().y] = true

    var cnt = 1

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until 5 || ny !in 0 until 5 || !visited[nx * 5 + ny] || bfsVisited[nx][ny]) continue
            q.offer(Node(nx, ny))
            bfsVisited[nx][ny] = true
            cnt++
        }
    }

    return cnt == 7
}