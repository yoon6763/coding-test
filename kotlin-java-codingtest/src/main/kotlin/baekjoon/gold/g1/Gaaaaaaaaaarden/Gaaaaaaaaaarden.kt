package baekjoon.gold.g1.Gaaaaaaaaaarden

import java.util.*

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

data class Node(var x: Int, var y: Int)

class Pair {
    var time = 0
    var type = 0

    constructor()
    constructor(time: Int, type: Int) {
        this.time = time
        this.type = type
    }
}

var n = 0
var m = 0
var green = 0
var red = 0
lateinit var garden: Array<IntArray>
lateinit var liquidPoints: ArrayList<Node>
lateinit var visited: BooleanArray
lateinit var greens: IntArray
lateinit var reds: IntArray
var max = 0
const val RED = 3
const val GREEN = 4
const val FLOWER = 5

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    green = st.nextToken().toInt()
    red = st.nextToken().toInt()
    liquidPoints = ArrayList()

    garden = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        st = StringTokenizer(readLine())
        for (j in 0 until m) {
            garden[i][j] = st.nextToken().toInt()
            if (garden[i][j] == 2) liquidPoints.add(Node(i, j))
        }
    }

    greens = IntArray(green)
    reds = IntArray(red)
    visited = BooleanArray(10)

    findGreen(0, 0)
    println(max)
}

fun findGreen(start: Int, g: Int) {
    if (g == green) {
        findRed(0, 0)
        return
    }

    for (i in start until liquidPoints.size) {
        if (!visited[i]) {
            visited[i] = true
            greens[g] = i
            findGreen(i + 1, g + 1)
            visited[i] = false
        }
    }
}

private fun findRed(start: Int, r: Int) {
    if (r == red) {
        bfs()
        return
    }

    for (i in start until liquidPoints.size) {
        if (!visited[i]) {
            visited[i] = true
            reds[r] = i
            findRed(i + 1, r + 1)
            visited[i] = false
        }
    }
}

fun bfs() {
    val q = LinkedList<Node>() as Queue<Node>
    val state = Array(n) { Array(m) { Pair() } }

    for (i in 0 until red) {
        val p = liquidPoints[reds[i]]
        state[p.x][p.y] = Pair(0, RED)
        q.offer(Node(p.x, p.y))
    }

    for (i in 0 until green) {
        val p = liquidPoints[greens[i]]
        state[p.x][p.y] = Pair(0, GREEN)
        q.offer(Node(p.x, p.y))
    }

    var sum = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()
        val cTime = state[cur.x][cur.y].time
        val cType = state[cur.x][cur.y].type

        if (state[cur.x][cur.y].type == FLOWER) continue

        for (i in 0 until 4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || garden[nx][ny] == 0) continue

            if (state[nx][ny].type == 0) {
                state[nx][ny] = Pair(cTime + 1, cType)
                q.offer(Node(nx, ny))
            } else if (state[nx][ny].time == cTime + 1 &&
                ((state[nx][ny].type == RED && cType == GREEN) || (state[nx][ny].type == GREEN && cType == RED))
            ) {
                sum++
                state[nx][ny].type = FLOWER
            }
        }
    }
    max = max.coerceAtLeast(sum)
}