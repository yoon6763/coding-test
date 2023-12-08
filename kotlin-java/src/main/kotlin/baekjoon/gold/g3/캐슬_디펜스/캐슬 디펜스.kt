package baekjoon.gold.g3.캐슬_디펜스

import java.util.ArrayDeque
import java.util.StringTokenizer

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(0, -1, 0) // 화살은 아래로 쏘지 않음
val dy = intArrayOf(-1, 0, 1) // 왼쪽 우선 탐색
var n = 0
var m = 0
var d = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nmd = readLine().split(" ").map { it.toInt() }
    n = nmd[0]
    m = nmd[1]
    d = nmd[2]

    val map = Array(n) { IntArray(m) }

    repeat(n) { x ->
        val st = StringTokenizer(readLine())
        repeat(m) { y ->
            map[x][y] = st.nextToken().toInt()
        }
    }

    var maxScore = 0

    for (i in 0..<m - 2) {
        for (j in i + 1..<m - 1) {
            for (k in j + 1..<m) {
                val copiedMap = Array(n) { x -> IntArray(m) { y -> map[x][y] } }
                val archerPoints = listOf(i, j, k)

                val score = playGame(archerPoints, copiedMap)
                maxScore = maxOf(maxScore, score)
            }
        }
    }

    println(maxScore)
}

fun playGame(archerPoints: List<Int>, map: Array<IntArray>): Int {
    var score = 0

    while (!gameIsEnd(map)) {
        score += playTurn(archerPoints, map)
        enemyMove(map)
    }

    return score
}

fun playTurn(archerPoints: List<Int>, map: Array<IntArray>): Int {
    val killedEnemy = HashSet<Node>()

    archerPoints.forEach { archerPoint ->
        shoot(archerPoint, map, killedEnemy)
    }

    killedEnemy.forEach { node ->
        map[node.x][node.y] = 0
    }

    return killedEnemy.size
}

fun shoot(archerPoint: Int, map: Array<IntArray>, killedEnemy: HashSet<Node>) {
    val queue = ArrayDeque<Node>()
    queue.add(Node(n, archerPoint))

    val visited = Array(n + 1) { IntArray(m) }

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (i in 0..<3) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]
            val nd = visited[cur.x][cur.y] + 1

            if (nx !in 0..<n || ny !in 0..<m || nd > d) continue

            if (map[nx][ny] == 1) {
                killedEnemy.add(Node(nx, ny))
                return
            }

            queue.add(Node(nx, ny))
            visited[nx][ny] = nd
        }
    }
}


fun gameIsEnd(map: Array<IntArray>) = map.all { it.all { it == 0 } }

fun enemyMove(map: Array<IntArray>) {
    for (i in n - 1 downTo 1) {
        map[i] = map[i - 1]
    }
    map[0] = IntArray(m) { 0 }
}