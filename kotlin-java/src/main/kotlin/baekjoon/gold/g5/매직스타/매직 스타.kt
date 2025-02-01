package baekjoon.gold.g5.매직스타

import kotlin.system.exitProcess

data class Node(val x: Int, val y: Int)

val visited = BooleanArray(13)

val stars = arrayOf(
    Node(-1, -1),
    Node(0, 4),
    Node(1, 1), Node(1, 3), Node(1, 5), Node(1, 7),
    Node(2, 2), Node(2, 6),
    Node(3, 1), Node(3, 3), Node(3, 5), Node(3, 7),
    Node(4, 4)
)

val lines = arrayOf(
    arrayOf(Node(0, 4), Node(1, 3), Node(2, 2), Node(3, 1)),
    arrayOf(Node(0, 4), Node(1, 5), Node(2, 6), Node(3, 7)),
    arrayOf(Node(1, 1), Node(1, 3), Node(1, 5), Node(1, 7)),
    arrayOf(Node(3, 1), Node(3, 3), Node(3, 5), Node(3, 7)),
    arrayOf(Node(4, 4), Node(3, 3), Node(2, 2), Node(1, 1)),
    arrayOf(Node(4, 4), Node(3, 5), Node(2, 6), Node(1, 7)),
)

lateinit var arr: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    arr = Array(5) { readLine().map { if (it in 'A'..'Z') it - 'A' + 1 else -1 }.toIntArray() }
    stars.drop(1).forEach { if (arr[it.x][it.y] != -1) visited[arr[it.x][it.y]] = true }
    solve(1)
}

fun solve(index: Int) {
    if (index == 13) {
        for (line in lines) {
            val sum = line.sumOf { arr[it.x][it.y] }
            if (sum != 26) return
        }

        println(arr.joinToString("\n") { it.joinToString("") { (if (it != -1) (it + 'A'.toInt() - 1).toChar() else '.').toString() } })
        exitProcess(0)
    }

    val pos = stars[index]

    if (arr[pos.x][pos.y] != -1) {
        solve(index + 1)
        return
    }

    for (i in 1..12) {
        if (visited[i]) continue
        visited[i] = true
        arr[pos.x][pos.y] = i
        solve(index + 1)
        visited[i] = false
        arr[pos.x][pos.y] = -1
    }
}