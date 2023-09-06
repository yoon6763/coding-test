package groom.groomthonchallenge.p18_중첩점

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map(String::toInt)
    val map = Array(n) { Array(n) { Array(2) { 0L } } }

    repeat(m) {
        val yxd = readLine().split(" ")
        val y = yxd[0].toInt() - 1
        val x = yxd[1].toInt() - 1
        val d = yxd[2]

        when (d) {
            "U" -> for (i in y downTo 0) map[i][x][0]++
            "D" -> for (i in y until n) map[i][x][0]++
            "L" -> for (i in x downTo 0) map[y][i][1]++
            "R" -> for (i in x until n) map[y][i][1]++
        }
    }

    println(map.sumOf { it.sumOf { it[0] * it[1] } })
}