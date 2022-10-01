package baekjoon.gold.g3.파티

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

val MAX = 1000000000
var n = 0
lateinit var distance: Array<Int>
lateinit var reverseDistance: Array<Int>
lateinit var visited: Array<Boolean>
lateinit var weight: Array<Array<Int>>
lateinit var reverseWeight: Array<Array<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nmx = br.readLine().split(" ").map { it.toInt() } // n - 학생 수, m - 간선 수, x - 목표 마을
    n = nmx[0]
    val m = nmx[1]
    val x = nmx[2] - 1

    distance = Array(n) { MAX }
    reverseDistance = Array(n) { MAX }
    visited = Array(n) { false }

    weight = Array(n) { Array(n) { MAX } }
    reverseWeight = Array(n) { Array(n) { MAX } }

    repeat(n) {
        weight[it][it] = 0
        reverseWeight[it][it] = 0
    }

    repeat(m) {
        val st = StringTokenizer(br.readLine(), " ")
        val from = st.nextToken().toInt() - 1
        val to = st.nextToken().toInt() - 1
        val w = st.nextToken().toInt()
        weight[from][to] = w
        reverseWeight[to][from] = w
    }

    var result = 0

    dijkstra(x, false)
    repeat(n) { visited[it] = false }
    dijkstra(x, true)

    repeat(n) {
        result = max(result, distance[it] + reverseDistance[it])
    }

    println(result)
}


private fun getSmallIndex(isReverse: Boolean): Int {
    var min = MAX
    var index = 0

    val distance = if (!isReverse) distance else reverseDistance

    for (i in 0 until n) {
        if (distance[i] < min && !visited[i]) {
            min = distance[i]
            index = i
        }
    }
    return index
}

private fun dijkstra(start: Int, isReverse: Boolean) {

    val weight = if (!isReverse) weight else reverseWeight
    val distance = if (!isReverse) distance else reverseDistance

    for (i in 0 until n) distance[i] = weight[start][i]

    visited[start] = true

    for (i in 0 until n - 2) {
        val current = getSmallIndex(isReverse)
        visited[current] = true

        for (j in 0 until n) {
            if (!visited[j] && (distance[current] + weight[current][j] < distance[j])) {
                distance[j] = distance[current] + weight[current][j]
            }
        }
    }
}

/*
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
 */