package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val grid = Array(n) { readln() }

    var flag = true
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (grid[i][j] == grid[j][i]) continue
            flag = false
            break
        }
        if (!flag) break
    }

    println(if (flag) "YES" else "NO")
}
