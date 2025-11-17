package baekjoon.silver.s1

import java.util.*

fun main() {
    data class Node(val x: Int, val y: Int)

    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    val answerMap = Array(n) { BooleanArray(m) }

    var st = StringTokenizer(readln())
    val queenSize = st.nextToken().toInt()
    val queens = Array(queenSize) {
        val node = Node(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1)
        map[node.x][node.y] = 1
        answerMap[node.x][node.y] = true
        node
    }

    st = StringTokenizer(readln())

    val knightSize = st.nextToken().toInt()
    val knights = Array(knightSize) {
        val node = Node(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1)
        map[node.x][node.y] = 2
        answerMap[node.x][node.y] = true
        node
    }

    st = StringTokenizer(readln())
    repeat(st.nextToken().toInt()) {
        val x = st.nextToken().toInt() - 1
        val y = st.nextToken().toInt() - 1
        answerMap[x][y] = true
        map[x][y] = 3
    }

    val queenDx = intArrayOf(1, -1, 0, 0, 1, 1, -1, -1)
    val queenDy = intArrayOf(0, 0, 1, -1, 1, -1, 1, -1)

    queens.forEach { queen ->
        repeat(8) { dir ->
            var nx = queen.x
            var ny = queen.y
            while (true) {
                nx += queenDx[dir]
                ny += queenDy[dir]
                if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] != 0) break
                answerMap[nx][ny] = true
            }
        }
    }

    val knightDx = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
    val knightDy = intArrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

    knights.forEach { knight ->
        repeat(8) { dir ->
            val nx = knight.x + knightDx[dir]
            val ny = knight.y + knightDy[dir]
            if (nx in 0..<n && ny in 0..<m && map[nx][ny] == 0) {
                answerMap[nx][ny] = true
            }
        }
    }

    println(answerMap.sumOf { it.count { !it } })
}