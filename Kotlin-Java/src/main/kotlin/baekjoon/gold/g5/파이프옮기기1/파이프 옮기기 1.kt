package baekjoon.gold.g5.파이프옮기기1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

enum class Direction { VERTICAL, HORIZONTAL, DIAGONAL }

private lateinit var map: Array<Array<Int>>
var n = 0
var cnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    map = Array(n) { Array(n) { 0 } }

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(n) { y ->
            map[x][y] = st.nextToken().toInt()
        }
    }

    dfs(0, 1, Direction.HORIZONTAL)
    println(cnt)
}

fun dfs(x: Int, y: Int, direction: Direction) {
    if (x >= n || y >= n || map[x][y] == 1 ||
        (direction == Direction.DIAGONAL && (map[x - 1][y] == 1 || map[x][y - 1] == 1))
    ) return

    if (x == n - 1 && y == n - 1) {
        cnt++
        return
    }

    when (direction) {
        Direction.HORIZONTAL -> {
            dfs(x, y + 1, Direction.HORIZONTAL)
            dfs(x + 1, y + 1, Direction.DIAGONAL)
        }

        Direction.VERTICAL -> {
            dfs(x + 1, y, Direction.VERTICAL)
            dfs(x + 1, y + 1, Direction.DIAGONAL)
        }

        Direction.DIAGONAL -> {
            dfs(x, y + 1, Direction.HORIZONTAL)
            dfs(x + 1, y, Direction.VERTICAL)
            dfs(x + 1, y + 1, Direction.DIAGONAL)
        }
    }
}