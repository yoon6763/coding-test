package baekjoon.platinum.p4.탈옥

import kotlin.collections.ArrayDeque

data class Node(var x: Int, var y: Int, var count: Int)

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
lateinit var prisoner1Map: Array<IntArray>
lateinit var prisoner2Map: Array<IntArray>
lateinit var sgMap: Array<IntArray>

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val nm = readLine().split(" ").map(String::toInt)
        n = nm[0]
        m = nm[1]

        map = Array(n + 2) { CharArray(m + 2) }
        prisoner1Map = Array(n + 2) { IntArray(m + 2) }
        prisoner2Map = Array(n + 2) { IntArray(m + 2) }
        sgMap = Array(n + 2) { IntArray(m + 2) }

        val persons = ArrayList<Node>()

        for (i in 0 until n) {
            val line = readLine()

            for (j in line.indices) {
                map[i + 1][j + 1] = line[j]

                if (line[j] == '$') {
                    persons.add(Node(i + 1, j + 1, 0))
                }
            }
        }


        bfs(persons[0], prisoner1Map)
        bfs(persons[1], prisoner2Map)
        bfs(Node(0, 0, 0), sgMap)

        var answer = Int.MAX_VALUE

        for (i in 1..n) {
            for (j in 1..m) {
                if (map[i][j] == '*') continue

                var sum = prisoner1Map[i][j] + prisoner2Map[i][j] + sgMap[i][j]
                if (map[i][j] == '#') sum -= 2

                if (visited[i][j] && sum >= 0) answer = answer.coerceAtMost(sum)
            }
        }
        sb.appendLine(answer)
    }

    print(sb)
}

fun bfs(start: Node, personMap: Array<IntArray>) {
    val queue = ArrayDeque<Node>()
    queue.add(start)

    visited = Array(n + 2) { BooleanArray(m + 2) }
    visited[start.x][start.y] = true

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        for (i in 0 until 4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0 until n + 2 || ny !in 0 until m + 2 || map[nx][ny] == '*' || visited[nx][ny]) continue

            visited[nx][ny] = true

            if (map[nx][ny] == '#') {
                personMap[nx][ny] = personMap[cur.x][cur.y] + 1
                queue.addLast(Node(nx, ny, personMap[nx][ny]))
            } else {
                personMap[nx][ny] = personMap[cur.x][cur.y]
                queue.addFirst(Node(nx, ny, personMap[nx][ny]))
            }
        }
    }
}