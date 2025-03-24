package baekjoon.silver.s2.`Bad Grass`

val dx = intArrayOf(1, -1, 0, 0, 1, 1, -1, -1)
val dy = intArrayOf(0, 0, 1, -1, 1, -1, 1, -1)

lateinit var map: Array<IntArray>
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    var cnt = 0


    repeat(n){x->
        repeat(m){y->
            if(map[x][y] != 0) {
                dfs(x,y)
                cnt++
            }
        }
    }

    print(cnt)
}

fun dfs(x: Int, y: Int) {
    map[x][y] = 0

    for (i in 0 until 8) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 0) continue
        dfs(nx, ny)
    }
}