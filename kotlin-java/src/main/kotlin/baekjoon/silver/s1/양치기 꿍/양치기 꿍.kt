package baekjoon.silver.s1.`양치기 꿍`

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var tempSheep = 0
var tempWolf = 0
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) }

    var aliveSheep = 0
    var aliveWolf = 0

    repeat(n) { x ->
        repeat(m) { y ->
            if (map[x][y] != '#') {
                tempSheep = 0
                tempWolf = 0
                dfs(x, y)
                if (tempSheep > tempWolf) aliveSheep += tempSheep
                else aliveWolf += tempWolf
            }
        }
    }

    println("$aliveSheep $aliveWolf")
}

fun dfs(x: Int, y: Int) {
    if (x !in 0..<n || y !in 0..<m || map[x][y] == '#' || visited[x][y]) return
    visited[x][y] = true
    when (map[x][y]) {
        'k' -> tempSheep++
        'v' -> tempWolf++
    }

    for (i in 0..<4) {
        dfs(x + dx[i], y + dy[i])
    }
}