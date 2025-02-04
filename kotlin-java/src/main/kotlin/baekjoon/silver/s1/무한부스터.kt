package baekjoon.silver.s1

fun main() = with(System.`in`.bufferedReader()) {
    data class Node(val x: Int, val y: Int)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array(n) { IntArray(m) }

    val dx = intArrayOf(1, 0)
    val dy = intArrayOf(0, 1)

    val queue = ArrayDeque<Node>()
    queue.add(Node(0, 0))
    dp[0][0] = 1

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        val jump = arr[x][y]
        arr[x][y] = 0

        for (i in 0..<2) {
            for (j in 1..jump) {
                val nx = x + dx[i] * j
                val ny = y + dy[i] * j

                if (nx !in 0..<n || ny !in 0..<m) break
                if (dp[nx][ny] != 0) continue

                dp[nx][ny] = dp[x][y] + 1
                queue.add(Node(nx, ny))
            }
        }
    }

    println(dp[n - 1][m - 1] - 1)
}