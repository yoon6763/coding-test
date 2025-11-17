package baekjoon.gold.g4.`연구소 2`

data class Node(var x: Int, var y: Int)

lateinit var selectedVirus: BooleanArray
lateinit var map: Array<Array<Int>>
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)
val virusPoints = ArrayList<Node>()
var n = 0
var m = 0
var answer = Int.MAX_VALUE
var emptyCount = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]
    map = Array(n) { Array(n) { 0 } }
    emptyCount = n * n

    repeat(n) { x ->
        val line = readLine().split(" ").map { it.toInt() }
        repeat(n) { y ->
            map[x][y] = line[y]
            if (map[x][y] == 2) {
                virusPoints.add(Node(x, y))
            } else if (map[x][y] == 1) {
                emptyCount--
            }
        }
    }
    selectedVirus = BooleanArray(virusPoints.size)

    selectVirus(0, 0)

    println(if (answer == Int.MAX_VALUE) -1 else answer - 1)
}

fun selectVirus(index: Int, selectedCount: Int) {
    if (selectedCount == m) {
        spreadVirus()
        return
    }

    for (i in index until virusPoints.size) {
        selectedVirus[i] = true
        selectVirus(i + 1, selectedCount + 1)
        selectedVirus[i] = false
    }
}

fun spreadVirus() {
    val q = ArrayDeque<Node>()
    val visited = Array(n) { BooleanArray(n) { false } }
    var nowEmptyCount = emptyCount
    var time = 0

    for (i in 0 until virusPoints.size) {
        if (selectedVirus[i]) {
            q.add(virusPoints[i])
            visited[virusPoints[i].x][virusPoints[i].y] = true
            nowEmptyCount--
        }
    }

    while (q.isNotEmpty()) {
        time++

        repeat(q.size) {
            val cur = q.removeFirst()
            for (i in 0 until 4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] || map[nx][ny] == 1) continue
                nowEmptyCount--
                visited[nx][ny] = true
                q.add(Node(nx, ny))
            }
        }
    }

    if (nowEmptyCount == 0) {
        answer = minOf(answer, time)
    }
}