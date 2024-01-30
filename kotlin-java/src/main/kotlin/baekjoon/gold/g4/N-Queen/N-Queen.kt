package baekjoon.gold.g4.`N-Queen`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

var n = 0
var resultCnt = 0
lateinit var queen: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    n = br.readLine().toInt()

    queen = Array(n) { -1 }

    dfs(0)

    println(resultCnt)
}

fun dfs(depth: Int) {
    if (depth == n) {
        resultCnt++
        return
    }

    for (i in 0 until n) {
        queen[depth] = i
        if (check(depth)) {
            dfs(depth + 1)
        }
    }
}

fun check(depth: Int): Boolean {
    for (i in 0 until depth) {
        if (queen[depth] == queen[i])
            return false

        if (abs(depth - i) == abs(queen[i] - queen[depth]))
            return false
    }

    return true
}