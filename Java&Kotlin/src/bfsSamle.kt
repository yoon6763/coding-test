import java.util.LinkedList
import java.util.Queue

lateinit var map: Array<Array<Int>>

var n: Int = 0
var m: Int = 0

fun main() {
    val temp = readLine()!!.split(" ")
    n = temp[0].toInt()
    m = temp[1].toInt()

    map = Array(n) { Array(m) { 0 } }

    for (i in 0 until n) {
        val input = readLine()!!.trim()
        for (j in 0 until m) {
            map[i][j] = input[j] - '0'
        }
    }

    bfs()
}

// 이동 가능한 공간이 1

data class Node(val x: Int, val y: Int)

fun bfs() {
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)

    val q: Queue<Node> = LinkedList()
    q.offer(Node(0, 0))

    while (q.isNotEmpty()) {
        val node = q.poll()

        for (i in 0 until 4) {
            val nx = node.x + dx[i]
            val ny = node.y + dy[i]

            if (nx >= n || nx < 0 || ny < 0 || ny >= m || map[nx][ny] == 0) continue

            if (map[nx][ny] == 1) {
                map[nx][ny] = map[node.x][node.y] + 1
                q.offer(Node(nx, ny))
            }
        }
    }

    println(map[n - 1][m - 1])

}
