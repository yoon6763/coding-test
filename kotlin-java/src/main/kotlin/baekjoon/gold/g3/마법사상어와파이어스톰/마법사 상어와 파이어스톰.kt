package baekjoon.gold.g3.마법사상어와파이어스톰

import java.util.StringTokenizer
import kotlin.math.pow

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

lateinit var visited: Array<Array<Boolean>>
lateinit var map: Array<Array<Int>>
var max = 0
var squareN = 0
var cnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, q) = readLine().split(" ").map { it.toInt() }
    squareN = 2.0.pow(n).toInt()

    map = Array(squareN) {
        val st = StringTokenizer(readLine())
        Array(squareN) { st.nextToken().toInt() }
    }

    val st = StringTokenizer(readLine())
    while (st.hasMoreTokens()) {
        val l = st.nextToken().toInt()

        val size = 2.0.pow(l).toInt()

        val copiedMap = Array(squareN) { Array(squareN) { 0 } }

        for (startX in 0 until squareN step size) {
            for (startY in 0 until squareN step size) {
                for (i in 0 until size) {
                    for (j in 0 until size) {
                        copiedMap[i + startX][j + startY] = map[size - 1 - j + startX][i + startY]
                    }
                }
            }
        }

        val minus = Array(squareN) { Array(squareN) { false } }

        repeat(squareN) { x ->
            repeat(squareN) { y ->
                var cnt = 0

                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx !in 0 until squareN || ny !in 0 until squareN || copiedMap[nx][ny] == 0) continue
                    cnt++
                }

                if (cnt < 3) minus[x][y] = true
            }
        }

        repeat(squareN) { x ->
            repeat(squareN) { y ->
                map[x][y] = copiedMap[x][y]
                if (minus[x][y] && map[x][y] > 0) map[x][y]--
            }
        }
    }

    visited = Array(squareN) { Array(squareN) { false } }

    val sum = map.sumOf { it.sum() }
    repeat(squareN) { x ->
        repeat(squareN) { y ->
            dfs(x, y)
            cnt = 0
        }
    }
    println("$sum\n$max")
}

fun dfs(x: Int, y: Int) {
    if (map[x][y] == 0 || visited[x][y]) return
    visited[x][y] = true
    cnt++
    max = maxOf(max, cnt)

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until squareN || ny !in 0 until squareN) continue

        dfs(nx, ny)
    }
}