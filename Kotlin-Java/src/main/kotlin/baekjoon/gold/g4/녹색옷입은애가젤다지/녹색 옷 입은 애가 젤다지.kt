package baekjoon.gold.g4.녹색옷입은애가젤다지

import java.util.*

data class Node(val x: Int, val y: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.weight - other.weight
    }
}

lateinit var map: Array<Array<Int>>
lateinit var table: Array<Array<Int>>
const val MAX_VALUE = 987654321
var n = 0
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()
    var caseIdx = 1

    while (true) {
        n = readLine().toInt()
        if (n == 0) break

        map = Array(n) { StringTokenizer(readLine()).let { st -> Array(n) { st.nextToken().toInt() } } }
        table = Array(n) { Array(n) { MAX_VALUE } }

        dijkstra()
        sb.append("Problem ${caseIdx++}: ${table[n - 1][n - 1]}\n")
    }

    print(sb)
}


fun dijkstra() {
    val pq = PriorityQueue<Node>()
    table[0][0] = map[0][0]

    // 0, 0 부터 탐색 시작
    pq.offer(Node(0, 0, map[0][0]))

    while (pq.isNotEmpty()) {
        val target = pq.poll()

        // 상하좌우 탐색
        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until n) continue

            if (table[nx][ny] > table[target.x][target.y] + map[nx][ny]) {
                table[nx][ny] = table[target.x][target.y] + map[nx][ny]
                pq.offer(Node(nx, ny, table[nx][ny]))
            }
        }
    }
}