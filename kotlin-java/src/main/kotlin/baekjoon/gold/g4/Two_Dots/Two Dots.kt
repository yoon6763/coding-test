package baekjoon.gold.g4.Two_Dots

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().toCharArray() }

    val visited = Array(n) { BooleanArray(m) }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun dfs(x: Int, y: Int, startX: Int, startY: Int, depth: Int): Boolean {
        if (x !in 0..<n || y !in 0..<m || arr[x][y] != arr[startX][startY]) return false
        if (visited[x][y]) return depth >= 4 && x == startX && y == startY

        visited[x][y] = true
        for (i in 0..<4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (dfs(nx, ny, startX, startY, depth + 1)) return true
        }
        visited[x][y] = false
        return false
    }

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (dfs(i, j, i, j, 1)) {
                println("Yes")
                return
            }
        }
    }

    println("No")
}