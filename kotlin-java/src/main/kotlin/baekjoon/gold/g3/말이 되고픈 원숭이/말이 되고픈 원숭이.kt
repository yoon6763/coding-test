package baekjoon.gold.g3.`말이 되고픈 원숭이`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Point(var x: Int, var y: Int, var d: Int, var k: Int)

fun main() {

    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)
    val hx = arrayOf(-2, -2, 2, 2, 1, -1, 1, -1)
    val hy = arrayOf(1, -1, 1, -1, 2, 2, -2, -2)


    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toInt()
    val wh = br.readLine().split(" ")

    val w = wh[0].toInt()
    val h = wh[1].toInt()

    val map = Array(h) { Array(w) { 0 } }

    repeat(h) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(w) { y -> map[x][y] = st.nextToken().toInt() }
    }

    val q: Queue<Point> = LinkedList()
    val visited = Array(h) { Array(w) { Array(k + 1) { false } } }

    // 맨 왼쪽 위 -> 맨 오른쪽 아래
    q.offer(Point(0, 0, 0, 0))
    visited[0][0][0] = true

    while (q.isNotEmpty()) {
        val target = q.poll()
        val tx = target.x
        val ty = target.y
        val tk = target.k
        val td = target.d

        if (tx == h - 1 && ty == w - 1) {
            println(td)
            return
        }

        // 상하좌우
        for (i in 0 until 4) {
            val nx = tx + dx[i]
            val ny = ty + dy[i]

            if (nx !in 0 until h || ny !in 0 until w || visited[nx][ny][tk] || map[nx][ny] == 1) continue
            q.offer(Point(nx, ny, td + 1, tk))
            visited[nx][ny][tk] = true
        }

        // knight 처럼 움직임
        if (tk < k) {
            for (i in 0 until 8) {
                val nx = tx + hx[i]
                val ny = ty + hy[i]
                val nk = tk + 1

                if (nx !in 0 until h || ny !in 0 until w || visited[nx][ny][nk] || map[nx][ny] == 1) continue
                q.offer(Point(nx, ny, td + 1, nk))
                visited[nx][ny][nk] = true
            }
        }
    }

    println(-1)
}