package baekjoon.platinum.p5.`체스판 여행 1`

import java.util.*

data class Node(val x: Int, val y: Int, val type: Int, val depth: Int)

lateinit var board: Array<IntArray>
var n = 0

val knightDx = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
val knightDy = intArrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

val bishopDx = intArrayOf(-1, -1, 1, 1)
val bishopDy = intArrayOf(-1, 1, -1, 1)

val rookDx = intArrayOf(-1, 1, 0, 0)
val rookDy = intArrayOf(0, 0, -1, 1)

var startX = 0
var startY = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    board = Array(n) { x ->
        val st = StringTokenizer(readLine())
        IntArray(n) { y ->
            val num = st.nextToken().toInt()
            if (num == 1) {
                startX = x
                startY = y
            }
            num
        }
    }

    println(bfs())
}

fun bfs(): Int {
    val visited = Array(n) { Array(n) { Array(3) { IntArray(n * n + 1) } } }
    val q = ArrayDeque<Node>()

    for (type in 0..<3) {
        q.add(Node(startX, startY, type, 1))
        visited[startX][startY][type][1] = 1
    }

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        if (cur.depth == n * n) {
            continue
        }

        when (cur.type) {
            0 -> {
                for (i in knightDx.indices) {
                    val nx = cur.x + knightDx[i]
                    val ny = cur.y + knightDy[i]

                    if (nx !in 0..<n || ny !in 0..<n) continue

                    if (board[nx][ny] == cur.depth + 1 && visited[nx][ny][cur.type][cur.depth + 1] == 0) {
                        visited[nx][ny][cur.type][cur.depth + 1] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                        q.add(Node(nx, ny, cur.type, cur.depth + 1))
                    }

                    if (visited[nx][ny][cur.type][cur.depth] == 0) {
                        visited[nx][ny][cur.type][cur.depth] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                        q.add(Node(nx, ny, cur.type, cur.depth))
                    }
                }

                if (visited[cur.x][cur.y][1][cur.depth] == 0) {
                    visited[cur.x][cur.y][1][cur.depth] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                    q.add(Node(cur.x, cur.y, 1, cur.depth))
                }

                if (visited[cur.x][cur.y][2][cur.depth] == 0) {
                    visited[cur.x][cur.y][2][cur.depth] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                    q.add(Node(cur.x, cur.y, 2, cur.depth))
                }
            }

            1 -> {
                for (i in bishopDx.indices) {
                    for (j in 1..n) {
                        val nx = cur.x + bishopDx[i] * j
                        val ny = cur.y + bishopDy[i] * j

                        if (nx !in 0..<n || ny !in 0..<n) break

                        if (board[nx][ny] == cur.depth + 1 && visited[nx][ny][cur.type][cur.depth + 1] == 0) {
                            visited[nx][ny][cur.type][cur.depth + 1] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                            q.add(Node(nx, ny, cur.type, cur.depth + 1))
                        }

                        if (visited[nx][ny][cur.type][cur.depth] == 0) {
                            visited[nx][ny][cur.type][cur.depth] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                            q.add(Node(nx, ny, cur.type, cur.depth))
                        }
                    }
                }

                if (visited[cur.x][cur.y][0][cur.depth] == 0) {
                    visited[cur.x][cur.y][0][cur.depth] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                    q.add(Node(cur.x, cur.y, 0, cur.depth))
                }

                if (visited[cur.x][cur.y][2][cur.depth] == 0) {
                    visited[cur.x][cur.y][2][cur.depth] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                    q.add(Node(cur.x, cur.y, 2, cur.depth))
                }
            }

            2 -> {
                for (i in rookDx.indices) {
                    for (j in 1..n) {
                        val nx = cur.x + rookDx[i] * j
                        val ny = cur.y + rookDy[i] * j

                        if (nx !in 0..<n || ny !in 0..<n) break

                        if (board[nx][ny] == cur.depth + 1 && visited[nx][ny][cur.type][cur.depth + 1] == 0) {
                            visited[nx][ny][cur.type][cur.depth + 1] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                            q.add(Node(nx, ny, cur.type, cur.depth + 1))
                        }

                        if (visited[nx][ny][cur.type][cur.depth] == 0) {
                            visited[nx][ny][cur.type][cur.depth] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                            q.add(Node(nx, ny, cur.type, cur.depth))
                        }
                    }
                }

                if (visited[cur.x][cur.y][0][cur.depth] == 0) {
                    visited[cur.x][cur.y][0][cur.depth] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                    q.add(Node(cur.x, cur.y, 0, cur.depth))
                }

                if (visited[cur.x][cur.y][1][cur.depth] == 0) {
                    visited[cur.x][cur.y][1][cur.depth] = visited[cur.x][cur.y][cur.type][cur.depth] + 1
                    q.add(Node(cur.x, cur.y, 1, cur.depth))
                }
            }
        }
    }

    var endX = 0
    var endY = 0

    findEnd@ for (i in 0..<n) {
        for (j in 0..<n) {
            if (board[i][j] == n * n) {
                endX = i
                endY = j
                break@findEnd
            }
        }
    }

    var min = Int.MAX_VALUE
    for (type in 0..<3) {
        if (visited[endX][endY][type][n * n] != 0) min = minOf(min, visited[endX][endY][type][n * n] - 1)
    }

    return min
}