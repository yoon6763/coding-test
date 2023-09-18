package groomthonchallenge.lv2.p9_폭탄구현하기_2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map(String::toInt)
    val map = Array(n) { readLine().split(" ") }
    val ansMap = Array(n) { Array(n) { 0 } }

    val dx = arrayOf(-1, 0, 1, 0, 0)
    val dy = arrayOf(0, 1, 0, -1, 0)

    repeat(m) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }

        for (i in 0 until 5) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until n || ny !in 0 until n || map[nx][ny] == "#") continue
            if (map[nx][ny] == "@") ansMap[nx][ny] += 2
            else ansMap[nx][ny]++
        }
    }

    println(ansMap.maxOf { it.maxOf { it } })
}