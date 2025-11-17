package baekjoon.silver.s2

fun main() {
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        val connected = Array(n) { BooleanArray(n) }

        repeat(m) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            connected[a][b] = true
            connected[b][a] = true
        }

        fun dfs(cur: Int, depth: Int): Int {
            var maxDepth = depth
            for (next in 0 until n) {
                if (!connected[cur][next]) continue
                connected[cur][next] = false
                connected[next][cur] = false
                maxDepth = maxOf(maxDepth, dfs(next, depth + 1))
                connected[cur][next] = true
                connected[next][cur] = true
            }
            return maxDepth
        }

        println((0..<n).maxOf { dfs(it, 0) })
    }
}