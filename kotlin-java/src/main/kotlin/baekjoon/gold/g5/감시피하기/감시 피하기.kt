package baekjoon.gold.g5.감시피하기

import kotlin.system.exitProcess

data class Node(val x: Int, val y: Int)

lateinit var board: Array<CharArray>
val students = mutableListOf<Node>()
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    board = Array(n) { x -> readLine().split(" ").mapIndexed { y, c -> c[0].also { if (it == 'S') students.add(Node(x, y)) } }.toCharArray() }
    solve(0, 0)
    println("NO")
}

fun solve(index: Int, depth: Int) {
    if (depth == 3) {
        if (check()) {
            println("YES")
            exitProcess(0)
        }
        return
    }

    for (i in index..<n * n) {
        val (x, y) = i / n to i % n
        if (board[x][y] != 'X') continue
        board[x][y] = 'O'
        solve(i + 1, depth + 1)
        board[x][y] = 'X'
    }
}


fun check(): Boolean {
    students.forEach { (x, y) ->
        for (i in 0..<4) {
            var nx = x
            var ny = y
            while (true) {
                nx += dx[i]
                ny += dy[i]
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 'O') break
                if (board[nx][ny] == 'T') return false
            }
        }
    }
    return true
}