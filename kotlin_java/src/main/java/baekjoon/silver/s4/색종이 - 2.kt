package baekjoon.silver.s4

fun main() {
    val map = Array(101) { BooleanArray(101) }
    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        for (i in x..<x + 10) {
            for (j in y..<y + 10) {
                map[i][j] = true
            }
        }
    }

    var ans = 0
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    for (i in 0..100) {
        for (j in 0..100) {
            if (!map[i][j]) continue

            for (k in 0..3) {
                val nx = i + dx[k]
                val ny = j + dy[k]
                if (nx < 0 || nx > 100 || ny < 0 || ny > 100) continue
                if (!map[nx][ny]) {
                    ans++
                }
            }
        }
    }
    println(ans)
}