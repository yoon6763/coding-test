package baekjoon.gold.g2.`소풍`

import kotlin.system.exitProcess

lateinit var selected: IntArray
lateinit var graph: Array<Array<Boolean>>
var k = 0
var n = 0
var f = 0

fun main() = with(System.`in`.bufferedReader()) {
    val knf = readLine().split(" ").map { it.toInt() }
    k = knf[0]
    n = knf[1]
    f = knf[2]

    graph = Array(n + 1) { Array(n + 1) { false } }

    repeat(f) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a][b] = true
        graph[b][a] = true
    }

    selected = IntArray(k)
    selectFriends(1, 0)

    println(-1)
}

fun selectFriends(index: Int, depth: Int) {
    if (!valid(depth - 1)) return

    if (depth == k) {
        println(selected.joinToString("\n"))
        exitProcess(0)
    }

    for (i in index..n) {
        selected[depth] = i
        selectFriends(i + 1, depth + 1)
    }
}

fun valid(depth: Int): Boolean {
    for (i in 0..<depth) {
        if (!graph[selected[i]][selected[depth]]) return false
    }

    return true
}