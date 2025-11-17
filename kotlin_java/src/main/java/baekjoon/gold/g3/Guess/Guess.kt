package baekjoon.gold.g3.`Guess`

import kotlin.system.exitProcess

lateinit var matrix: Array<Array<Char>>
lateinit var arr: IntArray
lateinit var acc: IntArray
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = IntArray(n)
    acc = IntArray(n)
    matrix = Array(n) { Array(n) { ' ' } }

    val input = readLine()
    var floor = 0
    var col = 0

    input.forEach { c ->
        matrix[floor][col] = c
        col++
        if (col == n) {
            floor++
            col = floor
        }
    }

    dfs(0)
}

fun dfs(index: Int) {
    if (index == n) {
        println(arr.joinToString(" "))
        exitProcess(0)
    }

    for (i in -10..10) {
        arr[index] = i
        acc[index] = if (index == 0) i else acc[index - 1] + i

        if (!valid(index)) continue
        dfs(index + 1)
    }
}

fun valid(right: Int): Boolean {
    for (left in 0..right) {
        val num = acc[right] - acc[left] + arr[left]
        if (num > 0 && matrix[left][right] != '+') return false
        if (num == 0 && matrix[left][right] != '0') return false
        if (num < 0 && matrix[left][right] != '-') return false
    }

    return true
}