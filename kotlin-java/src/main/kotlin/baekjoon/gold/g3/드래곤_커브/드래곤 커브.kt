package baekjoon.gold.g3.드래곤_커브

val dx = intArrayOf(0, -1, 0, 1)
val dy = intArrayOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(101) { BooleanArray(101) }

    repeat(n) {
        var (y, x, d, g) = readLine().split(" ").map { it.toInt() }
        val list = ArrayList<Int>()

        list.add(d)
        map[x][y] = true
        x += dx[d]
        y += dy[d]
        map[x][y] = true

        repeat(g) {
            for (i in list.size - 1 downTo 0) {
                val nd = (list[i] + 1) % 4
                x += dx[nd]
                y += dy[nd]

                map[x][y] = true
                list.add(nd)
            }
        }
    }

    var countSquare = 0
    for (i in 0..<100) {
        for (j in 0..<100) {
            if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                countSquare++
            }
        }
    }

    println(countSquare)
}