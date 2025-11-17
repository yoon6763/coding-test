package baekjoon.gold.g1.열쇠

import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int)

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>

var cnt = 0

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val nm = readLine().split(" ").map { it.toInt() }
        n = nm[0]
        m = nm[1]

        map = Array(n) { readLine().toCharArray() }
        cnt = 0

        val alreadyFoundKeys = readLine()

        if (alreadyFoundKeys[0] != '0') {
            for (ch in alreadyFoundKeys) {
                repeat(n) { x ->
                    repeat(m) { y ->
                        if (ch == map[x][y].lowercaseChar()) map[x][y] = '.'
                    }
                }
            }
        }
        var isFoundKey = true

        outer@ while (isFoundKey) {
            isFoundKey = false
            visited = Array(n) { BooleanArray(m) }


            for (i in 0 until n) {
                if (bfs(i, 0)) {
                    isFoundKey = true
                    continue@outer
                }
                if (bfs(i, m - 1)) {
                    isFoundKey = true
                    continue@outer

                }
            }

            for (i in 0 until m) {
                if (bfs(0, i)) {
                    isFoundKey = true
                    continue@outer
                }
                if (bfs(n - 1, i)) {
                    isFoundKey = true
                    continue@outer
                }
            }
        }

        sb.append(cnt).append("\n")
    }

    print(sb)
}

fun bfs(x: Int, y: Int): Boolean {
    if (map[x][y] == '*') return false
    if (map[x][y] in 'A'..'Z') return false
    if (map[x][y] == '$') {
        map[x][y] = '.'
        cnt++
    }

    if (map[x][y] in 'a'..'z') removeAlphabet(x, y)

    var isFoundKey = false

    val queue = LinkedList<Node>() as Queue<Node>
    visited[x][y] = true
    queue.offer(Node(x, y))

    while (queue.isNotEmpty()) {
        val target = queue.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == '*' || visited[nx][ny] || map[nx][ny] in 'A'..'Z') continue

            if (map[nx][ny] in 'a'..'z') {
                removeAlphabet(nx, ny)
                isFoundKey = true
            }

            if (map[nx][ny] == '$') {
                map[nx][ny] = '.'
                cnt++
            }

            visited[nx][ny] = true
            queue.offer(Node(nx, ny))
        }
    }
    return isFoundKey
}

fun removeAlphabet(x: Int, y: Int) {
    val alphabet = map[x][y].lowercaseChar()
    for (i in 0 until n) for (j in 0 until m) if (map[i][j].lowercaseChar() == alphabet) map[i][j] = '.'
}
