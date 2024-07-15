package baekjoon.silver.s1.`유닛 싫어`

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine() }
    val d = arrayOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )

    for (x in 0..<n) {
        for (y in 0..<m) {
            var cnt = 0
            if (map[x][y] == 'X') continue

            for ((dx, dy) in d) {
                val nx = x + dx
                val ny = y + dy
                if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == 'X') continue
                cnt++
            }

            if (cnt < 2) {
                println(1)
                return
            }
        }
    }

    println(0)
}