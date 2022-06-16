package baekjoon.silver.s2

import java.util.*

var graph: Array<IntArray>? = null
var visited: BooleanArray? = null
var n = 0
var m = 0
var startPoint = 0

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    startPoint = sc.nextInt()
    graph = Array(1001) { IntArray(1001) }!!
    visited = BooleanArray(1001)
    for (i in 0 until m) {
        val x = sc.nextInt()
        val y = sc.nextInt()
        graph!![y][x] = 1
        graph!![x][y] = graph!![y][x]
    }
    dfs(startPoint)
    visited = BooleanArray(1001)
    bfs()

}

fun dfs(p: Int) {
    visited!![p] = true
    print("$p ")
    for (j in 1..n) {
        if (graph!![p][j] == 1 && !visited!![j]) {
            dfs(j)
        }
    }
}

fun bfs() {
    println()
    val queue: Queue<Int> = LinkedList()
    queue.add(startPoint)
    visited!![startPoint] = true

    print("$startPoint ")

    while (queue.isNotEmpty()) {
        val temp = queue.poll()
        for (j in 1..n) {
            if (graph!![temp][j] == 1 && !visited!![j]) {
                queue.add(j)
                visited!![j] = true
                print("$j ")
            }
        }
    }
}