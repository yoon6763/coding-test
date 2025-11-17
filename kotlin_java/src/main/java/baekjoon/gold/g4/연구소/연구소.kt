package baekjoon.gold.g4.연구소

import java.util.*

data class Node(var x: Int, var y: Int)

lateinit var map: Array<Array<Int>>
val virusPoint = ArrayList<Node>()
var maxSafeCnt = 0
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    map = Array(n) { Array(m) { 0 } }
    repeat(n) { x ->
        val st = StringTokenizer(readLine())
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

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] == 0) {
                map[i][j] = 1
                makeWall(wallCnt + 1)
                map[i][j] = 0
            }
        }
    }
}

fun spreadVirus() {
    val q: Queue<Node> = LinkedList()
    val copiedMap = Array(n) { x -> Array(m) { y -> map[x][y]}}

    virusPoint.forEach {
        q.offer(Node(it.x, it.y))
    }

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0..<4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]
            if (nx !in 0..<n || ny !in 0..<m || copiedMap[nx][ny] != 0) continue

            q.offer(Node(nx, ny))
            copiedMap[nx][ny] = 2
        }
    }

    val safeDistrictCnt = copiedMap.sumOf { it.count { it == 0 } }
    maxSafeCnt = maxOf(maxSafeCnt, safeDistrictCnt)
}