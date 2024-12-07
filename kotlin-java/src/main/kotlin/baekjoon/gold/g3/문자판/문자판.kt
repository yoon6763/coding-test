package baekjoon.gold.g3.`문자판`

lateinit var map: Array<CharArray>
lateinit var dp: Array<Array<Array<Int>>>
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var target = ""
var n = 0
var m = 0
var k = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nmk = readLine().split(" ").map { it.toInt() }
    n = nmk[0]
    m = nmk[1]
    k = nmk[2]

    map = Array(n) { readLine().toCharArray() }
    target = readLine()
    dp = Array(n) { Array(m) { Array(target.length) { -1 } } }

    var answer = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] != target[0]) continue
            answer += dfs(i, j, 1)
        }
    }

    println(answer)
}

fun dfs(x: Int, y: Int, depth: Int): Int {
    if (depth == target.length) return 1

    if (dp[x][y][depth] != -1) return dp[x][y][depth]

    dp[x][y][depth] = 0
    for (i in 0..<4) {
        for (j in 1..k) {
            val nx = x + dx[i] * j
            val ny = y + dy[i] * j

            if (nx !in 0..<n || ny !in 0..<m) break
            if (map[nx][ny] != target[depth]) continue

            dp[x][y][depth] += dfs(nx, ny, depth + 1)
        }
    }

    return dp[x][y][depth]
}
