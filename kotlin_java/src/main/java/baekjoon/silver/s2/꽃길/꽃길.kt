package baekjoon.silver.s2.꽃길

lateinit var map: Array<IntArray>
lateinit var visited: Array<BooleanArray>
var n = 0
var answer = Int.MAX_VALUE
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { BooleanArray(n) }

    dfs(0, 0)

    println(answer)
}

fun dfs(index: Int, depth: Int) {
    if (depth == 3) {
        var sum = 0
        for (i in 0..<n) {
            for (j in 0..<n) {
                if (visited[i][j]) {
                    sum += map[i][j]
                }
            }
        }
        answer = minOf(answer, sum)
        return
    }

    next@ for (i in index..<n * n) {
        val x = i / n
        val y = i % n
        val adj = ArrayList<Pair<Int, Int>>().apply {
            add(Pair(x, y))
            for (j in 0..<4) {
                add(Pair(x + dx[j], y + dy[j]))
            }
        }

        for ((tempX, tempY) in adj) {
            if (tempX !in 0..<n || tempY !in 0..<n || visited[tempX][tempY]) continue@next
        }

        for ((tempX, tempY) in adj) {
            visited[tempX][tempY] = true
        }

        dfs(i, depth + 1)

        for ((tempX, tempY) in adj) {
            visited[tempX][tempY] = false
        }
    }
}