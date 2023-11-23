package baekjoon.gold.g4

import java.util.Deque
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.system.exitProcess

data class Point(var x: Int, var y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)

    val n = readLine().toInt() // 보드 크기 n x n
    val map = Array(n) { Array(n) { 0 } } // 0 빈 공간, 1 뱀, 2 사과
    val k = readLine().toInt() // 사과 개수
    map[0][0] = 1

    repeat(k) {
        val st = StringTokenizer(readLine())
        map[st.nextToken().toInt() - 1][st.nextToken().toInt() - 1] = 2
    }

    val dq = LinkedList<Point>() as Deque<Point>
    dq.offer(Point(0, 0))

    val l = readLine().toInt() // 방향 전환 횟수
    var dir = 0
    var cnt = 0

    val direChangeQ = LinkedList<Pair<Int, String>>() as Queue<Pair<Int, String>>

    repeat(l) {
        val st = StringTokenizer(readLine())
        direChangeQ.offer(Pair(st.nextToken().toInt(), st.nextToken()))
    }

    while (true) {
        cnt++

        val nx = dq.last.x + dx[dir]
        val ny = dq.last.y + dy[dir]

        if (nx !in 0 until n || ny !in 0 until n) {
            println(cnt)
            exitProcess(0)
        }

        if (map[nx][ny] == 2) {
            map[nx][ny] = 1
        } else if (map[nx][ny] == 1) {
            println(cnt)
            exitProcess(0)
        } else {
            val p = dq.poll()
            map[p.x][p.y] = 0
        }

        dq.offer(Point(nx, ny))
        map[nx][ny] = 1

        if (direChangeQ.isNotEmpty() && cnt == direChangeQ.peek().first) {
            val q = direChangeQ.poll()
            if (q.second == "D") {
                dir++
                if (dir > 3) dir = 0
            } else {
                dir--
                if (dir < 0) dir = 3
            }
        }
    }
}