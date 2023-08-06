package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val dx = arrayOf(0, 0, 1, -1, 1, 1, -1, -1)
    val dy = arrayOf(1, -1, 0, 0, 1, -1, 1, -1)
    val sb = StringBuilder()

    while (true) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        if (n + m == 0) break

        val map = Array(n) {
            val line = readLine()
            Array(m) { line[it] }
        }

        val cntMap = Array(n) { CharArray(m) }

        repeat(n) { x ->
            repeat(m) { y ->
                if (map[x][y] == '*') {
                    cntMap[x][y] = '*'
                } else {
                    var cnt = 0
                    repeat(8) { idx ->
                        val nx = x + dx[idx]
                        val ny = y + dy[idx]
                        if (nx in 0 until n && ny in 0 until m && map[nx][ny] == '*') cnt++
                    }
                    cntMap[x][y] = cnt.digitToChar()
                }
            }
            sb.append(cntMap[x].joinToString("")).append("\n")
        }
    }
    print(sb)
}