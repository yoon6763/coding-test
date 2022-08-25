package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

val MAX_VALUE = 100000000

lateinit var distance: Array<Int>
lateinit var visited: Array<Boolean>
lateinit var weight: Array<Array<Int>>

var n = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt() // 도시 개수
    val m = br.readLine().toInt() // 버스 개수

    weight = Array(n) { Array(n) { MAX_VALUE } }
    distance = Array(n) { MAX_VALUE }
    visited = Array(n) { false }

    repeat(m) {
        val abw = br.readLine().split(" ").map { it.toInt() }
        val a = abw[0] - 1
        val b = abw[1] - 1
        val w = abw[2]

        weight[a][b] = min(weight[a][b], w)
    }

    repeat(n) {
        weight[it][it] = 0
    }

    val goal = br.readLine().split(" ")

    val start = goal[0].toInt() - 1
    val end = goal[1].toInt() - 1

    dijkstra(start)

    println(distance[end])
}

private fun getSmallIndex(): Int {
    var min = MAX_VALUE
    var index = 0

    for (i in 0 until n) {
        if (distance[i] < min && !visited[i]) {
            min = distance[i]
            index = i
        }
    }
    return index
}

private fun dijkstra(start: Int) {
    for (i in 0 until n) distance[i] = weight[start][i]

    visited[start] = true

    for (i in 0 until n - 2) {
        val current = getSmallIndex()
        visited[current] = true

        for (j in 0 until n) {
            if (!visited[j] && (distance[current] + weight[current][j] < distance[j])) {
                distance[j] = distance[current] + weight[current][j]
            }
        }
    }
}