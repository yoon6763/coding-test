package baekjoon.silver.s1

fun main() = with(System.`in`.bufferedReader()) {
    val keypad = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9),
        arrayOf(0, -1, -1)
    )

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val query = Array(readLine().toInt()) { readLine().toInt() }
    val max = query.max()

    val dp = Array(max + 1) { Array(4) { IntArray(3) } }
    dp[1].forEach { it.fill(1) }

    for (depth in 1..max) {
        for (x in 0 until 4) {
            for (y in 0 until 3) {
                if (keypad[x][y] == -1) continue

                for (d in 0 until 4) {
                    val nx = x + dx[d]
                    val ny = y + dy[d]

                    if (nx !in 0 until 4 || ny !in 0 until 3 || keypad[nx][ny] == -1) continue
                    dp[depth][x][y] = (dp[depth][x][y] + dp[depth - 1][nx][ny]) % 1234567
                }
            }
        }
    }

    query.forEach {
        var sum = 0
        for (x in 0 until 4) {
            for (y in 0 until 3) {
                if (keypad[x][y] == -1) continue
                sum = (sum + dp[it][x][y]) % 1234567
            }
        }
        println(sum)
    }
}