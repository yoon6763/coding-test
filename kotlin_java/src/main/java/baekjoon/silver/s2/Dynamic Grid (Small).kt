package baekjoon.silver.s2

fun main() {
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    for (i in 1..readln().toInt()) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val map = Array(n) { readln().toCharArray() }

        println("Case #$i:")

        repeat(readln().toInt()) {
            val cmd = readln().split(" ")
            if (cmd[0] == "Q") {
                val visited = Array(n) { BooleanArray(m) }

                fun dfs(x: Int, y: Int): Boolean {
                    if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == '0') return false
                    visited[x][y] = true
                    for (i in 0..<4) dfs(x + dx[i], y + dy[i])
                    return true
                }
                println((0..<n).sumOf { x -> (0..<m).count { y -> dfs(x, y) } })
            } else map[cmd[1].toInt()][cmd[2].toInt()] = cmd[3][0]
        }
    }
}