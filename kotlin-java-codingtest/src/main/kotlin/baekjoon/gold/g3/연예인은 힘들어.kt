package baekjoon.gold.g3

import java.util.StringTokenizer

const val INF = 987654321

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val table = Array(n + 1) { Array(n + 1) { INF } }

    repeat(n + 1) {
        table[it][it] = 0
    }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (v1, v2, cost) = Triple(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        table[v1][v2] = minOf(table[v1][v2], cost)
        table[v2][v1] = minOf(table[v2][v1], cost)
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (table[i][j] > table[i][k] + table[k][j]) table[i][j] = table[i][k] + table[k][j]
            }
        }
    }

    val (pointJ, pointS) = readLine().split(" ").map { it.toInt() }

    var minDistance = INF

    for (destination in 1..n) {
        if (destination == pointJ || destination == pointS) continue
        if (table[pointJ][destination] == INF || table[pointS][destination] == INF) continue
        if (table[pointJ][destination] + table[pointS][destination] > minDistance) continue
        minDistance = table[pointJ][destination] + table[pointS][destination]
    }

    var minDistanceOfJihyeon = INF
    var answerIdx = -1

    for (destination in 1..n) {
        if (destination == pointJ || destination == pointS) continue
        if (table[pointJ][destination] + table[pointS][destination] != minDistance) continue
        if (table[pointJ][destination] > table[pointS][destination]) continue
        if (table[pointJ][destination] > minDistanceOfJihyeon) continue

        minDistanceOfJihyeon = table[pointJ][destination]
        answerIdx = destination
    }

    println(answerIdx)
}