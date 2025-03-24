package baekjoon.gold.g5.나의_인생에는_수학과_함께

import java.util.*

lateinit var map: Array<CharArray>
var min = Int.MAX_VALUE
var max = Int.MIN_VALUE
var n = 0
val calc = mapOf(
    '+' to { a: Int, b: Int -> a + b },
    '-' to { a: Int, b: Int -> a - b },
    '*' to { a: Int, b: Int -> a * b },
)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    map = Array(n) { StringTokenizer(readLine()).let { st -> CharArray(n) { st.nextToken().first() } } }

    dfs(0, 0, map[0][0].digitToInt(), ' ')

    println("$max $min")
}

fun dfs(x: Int, y: Int, sum: Int, oper: Char) {
    if (x == n - 1 && y == n - 1) {
        min = min.coerceAtMost(sum)
        max = max.coerceAtLeast(sum)
        return
    }

    for ((nx, ny) in listOf((x + 1 to y), (x to y + 1))) {
        if (nx !in 0..<n || ny !in 0..<n) continue
        if (map[nx][ny].isDigit()) dfs(nx, ny, calc[oper]!!(sum, map[nx][ny].digitToInt()), ' ')
        else dfs(nx, ny, sum, map[nx][ny])
    }
}