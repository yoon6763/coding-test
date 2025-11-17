package baekjoon.silver.s3.`죽음의 게임`

import kotlin.system.exitProcess

lateinit var arr: IntArray
var target = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    target = k
    arr = IntArray(n) { readLine().toInt() }

    dfs(0, 0)
}

fun dfs(cur: Int, depth: Int) {
    if (cur == target) {
        println(depth)
        exitProcess(0)
    }

    if (arr[cur] != -1) {
        val next = arr[cur]
        arr[cur] = -1
        dfs(next, depth + 1)
    } else {
        println(-1)
        exitProcess(0)
    }
}