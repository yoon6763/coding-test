package baekjoon.platinum.p3.`N-Rook`

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.map

lateinit var graph: Array<ArrayList<Int>>
lateinit var match: IntArray
lateinit var visited: BooleanArray

fun dfs(from: Int): Boolean {
    if (visited[from]) return false
    visited[from] = true
    for (next in graph[from]) {
        if (match[next] == -1 || dfs(match[next])) {
            match[next] = from
            return true
        }
    }
    return false
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val max = 5005
    val matrixSize = 105
    val map = Array(n + 2) { IntArray(m + 2) }

    graph = Array(max) { ArrayList<Int>() }
    match = IntArray(max) { -1 }
    visited = BooleanArray(max)

    val rNum = Array(matrixSize) { IntArray(matrixSize) }
    val cNum = Array(matrixSize) { IntArray(matrixSize) }

    for (i in 1..n) {
        val line = readLine().split(" ").map { it.toInt() }
        for (j in 1..m) {
            map[i][j] = line[j - 1]
        }
    }

    var rCnt = 1
    var cCnt = 1


    for (i in 1..n) {
        for (j in 1..m) {
            if (map[i][j] == 0) {
                rNum[i][j] = rCnt
            }
            if (map[i][j] != 2 && (j == m || map[i][j + 1] == 2)) rCnt++
        }
    }

    for (i in 1..m) {
        for (j in 1..n) {
            if (map[j][i] == 0) {
                cNum[j][i] = cCnt
            }
            if (map[j][i] != 2 && (j == n || map[j + 1][i] == 2)) cCnt++
        }
    }


    for (i in 1..n) {
        for (j in 1..m) {
            if (map[i][j] == 0) graph[rNum[i][j]].add(cNum[i][j])
        }
    }

    var ans = 0

    for (i in 1..rCnt) {
        Arrays.fill(visited, false)
        if (dfs(i)) ans++
    }

    println(ans)
}