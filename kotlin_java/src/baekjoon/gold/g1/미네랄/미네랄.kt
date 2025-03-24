package baekjoon.gold.g1.미네랄

import java.util.ArrayList
import java.util.StringTokenizer

data class Node(val x: Int, val y: Int)

lateinit var map: List<CharArray>
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().toCharArray() }.reversed()

    val k = readLine().toInt()
    val st = StringTokenizer(readLine())

    repeat(k) {
        val x = st.nextToken().toInt() - 1
        val isLTR = it % 2 == 0 // LTR -> Left To Right

        val isHitMineral = throwStick(x, isLTR)

        if (isHitMineral) {
            val foundCluster = findFloatingCluster()
            if (foundCluster.isEmpty()) return@repeat

            moveDownCluster(foundCluster)
        }
    }

    val sb = StringBuilder()
    map.reversed().forEach { sb.appendLine(it) }
    print(sb.toString())
}

fun moveDownCluster(foundCluster: ArrayList<Node>) {
    foundCluster.forEach { (x, y) -> map[x][y] = '*' } // 떨어질 클러스터는 '*'로 표시

    var maxDownDistance = Int.MAX_VALUE

    foundCluster.forEach { (x, y) ->
        var downDistance = 0

        for (height in x - 1 downTo 0) {
            if (map[height][y] == 'x') break
            downDistance++
        }

        maxDownDistance = minOf(maxDownDistance, downDistance)
    }

    foundCluster.forEach { (x, y) ->
        map[x][y] = '.'
        map[x - maxDownDistance][y] = 'x'
    }
}

fun findFloatingCluster(): ArrayList<Node> {
    val visited = Array(n) { BooleanArray(m) }
    visited[0].fill(true)

    val queue = ArrayDeque<Node>()
    for (i in 0..<m) {
        if (map[0][i] == 'x') {
            queue.add(Node(0, i))
        }
    }

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        for (i in 0..<4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny] || map[nx][ny] != 'x') continue

            visited[nx][ny] = true
            queue.add(Node(nx, ny))
        }
    }

    val floatingCluster = ArrayList<Node>()
    for (x in 1..<n) {
        for (y in 0..<m) {
            if (map[x][y] == 'x' && !visited[x][y]) {
                floatingCluster.add(Node(x, y))
            }
        }
    }

    return floatingCluster
}

fun throwStick(x: Int, isLTR: Boolean): Boolean {
    val range = if (isLTR) 0..<m else m - 1 downTo 0

    for (y in range) {
        if (map[x][y] == 'x') {
            map[x][y] = '.'
            return true
        }
    }
    return false
}