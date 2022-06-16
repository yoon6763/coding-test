package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)
var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()

    val map1 = Array(n) { Array(n) { ' ' } }
    val map2 = Array(n) { Array(n) { ' ' } }

    repeat(n) {
        val string = br.readLine()
        for (i in 0 until n) {
            map1[it][i] = string[i]

            if (string[i] == 'G') map2[it][i] = 'R'
            else map2[it][i] = string[i]
        }
    }

    var cnt1 = 0
    var cnt2 = 0

    repeat(n) { x ->
        repeat(n) { y ->
            if (dfs(x, y, map1)) cnt1++
            if (dfs(x, y, map2)) cnt2++
        }
    }
    print("$cnt1 $cnt2")

}

fun dfs(x: Int, y: Int, map: Array<Array<Char>>): Boolean {
    if (map[x][y] == ' ')
        return false

    val color = map[x][y]
    map[x][y] = ' '

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0 until n || ny !in 0 until n || color != map[nx][ny])
            continue
        dfs(nx, ny, map)
    }

    return true
}
/* 4 3
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
 */
