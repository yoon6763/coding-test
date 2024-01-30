package baekjoon.gold.g4.`특정한 최단 경로`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

const val MAX_VALUE = 10000000
lateinit var distance: Array<Int>
lateinit var weight: Array<Array<Int>>
lateinit var visited: Array<Boolean>
var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val ne = br.readLine().split(" ") // n - 정점 개수, e - 간선 개수
    n = ne[0].toInt()
    val e = ne[1].toInt()

    distance = Array(n) { MAX_VALUE }
    visited = Array(n) { false }
    weight = Array(n) { Array(n) { MAX_VALUE } }
    repeat(n) {
        weight[it][it] = 0
    }

    repeat(e) {
        val line = br.readLine().split(" ").map { it.toInt() }
        weight[line[0] - 1][line[1] - 1] = line[2]
        weight[line[1] - 1][line[0] - 1] = line[2]
    }

    val vertex = br.readLine().split(" ").map { it.toInt() }
    val v1 = vertex[0] - 1
    val v2 = vertex[1] - 1

    dijkstra(0)
    var len1 = distance[v1] // 0 -> v1 -> v2 -> n
    var len2 = distance[v2] // 0 -> v2 -> v1 -> n
    repeat(n) { visited[it] = false }

    dijkstra(v1)
    val distanceV1 = distance.copyOf()
    repeat(n) { visited[it] = false }

    dijkstra(v2)
    val distanceV2 = distance.copyOf()

    len1 += distanceV1[v2] + distanceV2[n - 1]
    len2 += distanceV2[v1] + distanceV1[n - 1]

    println("${if (len1 >= MAX_VALUE && len2 >= MAX_VALUE) -1 else min(len1, len2)}")
}

fun getSmallIdx(): Int { 
    var min = MAX_VALUE
    var idx = 0

    for (i in 0 until n) {
        if (distance[i] < min && !visited[i]) {
            min = distance[i]
            idx = i
        }
    }
    return idx
}


fun dijkstra(start: Int) {
    for (i in 0 until n) distance[i] = weight[start][i]
    visited[start] = true
    distance[start] = 0

    for (i in 0 until n - 2 ) {
        val current = getSmallIdx()
        visited[current] = true

        for (j in 0 until n) {
            if (!visited[j] && (distance[current] + weight[current][j] < distance[j])) {
                distance[j] = distance[current] + weight[current][j]
            }
        }
    }
}

/*
0 3 6 8
3 0 8 7
5 8 0 1
 */