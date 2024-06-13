package goormlevel.lv3.`단풍나무`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var arr = Array(n) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
    var day = 0

    if (arr.all { it.all { it == 0 } }) {
        println(0)
        return@with
    }

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    while (true) {
        day++

        val minus = Array(n) { Array(n) { 0 } }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (arr[i][j] == 0) continue

                for (k in 0 until 4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]

                    if (nx !in 0 until n || ny !in 0 until n || arr[nx][ny] != 0) continue
                    minus[i][j]++
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                arr[i][j] -= minus[i][j]
                if (arr[i][j] < 0) arr[i][j] = 0
            }
        }

        if (arr.all { it.all { it == 0 } }) break
    }

    println(day)
}