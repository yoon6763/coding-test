package baekjoon.gold.g4.연구소

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

var n = 0
var m = 0

lateinit var map: Array<Array<Int>>

data class Node(var x: Int, var y: Int)

val virusPoint = ArrayList<Node>()

var maxSafeCnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    map = Array(n) { Array(m) { 0 } }
    repeat(n) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(m) { y ->
            map[x][y] = st.nextToken().toInt()
            if (map[x][y] == 2) {
                virusPoint.add(Node(x, y))
            }
        }
    }
    makeWall(0)
    println(maxSafeCnt)
}

fun makeWall(wallCnt: Int) {
    if (wallCnt == 3) {
        spreadVirus()
        return
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0) {
                map[i][j] = 1
                makeWall(wallCnt + 1)
                map[i][j] = 0
            }
        }
    }

}

fun spreadVirus() {
    val q: Queue<Node> = LinkedList<Node>()

    val mapCopy = Array(n) { Array(m) { 0 } }
    repeat(n) {
        mapCopy[it] = map[it].clone()
    }

    virusPoint.forEach {
        q.offer(Node(it.x, it.y))
    }

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || mapCopy[nx][ny] != 0)
                continue

            q.offer(Node(nx, ny))
            mapCopy[nx][ny] = 2
        }
    }

    var safeDistrictCnt = 0

    // 안전 구역 확인
    repeat(n) { x ->
        repeat(m) { y ->
            if (mapCopy[x][y] == 0) safeDistrictCnt++
        }
    }
    if (maxSafeCnt < safeDistrictCnt) maxSafeCnt = safeDistrictCnt
}