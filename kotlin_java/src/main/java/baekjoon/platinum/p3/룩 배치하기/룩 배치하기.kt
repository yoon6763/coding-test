package baekjoon.platinum.p3.`룩 배치하기`

import java.util.*

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
    val n = readLine().toInt()
    val map = Array(n + 3) { CharArray(n + 3) }

    graph = Array(n * n + 2) { ArrayList<Int>() }
    match = IntArray(n * n + 2) { -1 }
    visited = BooleanArray(n * n + 2)

    for (i in 1..n) {
        val line = readLine()
        for (j in 1..n) {
            map[i][j] = line[j - 1]
        }
    }

    val rNum = Array(n + 2) { IntArray(n + 2) }
    val cNum = Array(n + 2) { IntArray(n + 2) }
    var rCnt = 1
    var cCnt = 1

    for (i in 1..n) {
        for (j in 1..n) {
            if (map[i][j] == '.') {
                rNum[i][j] = rCnt
                if (j == n || map[i][j + 1] == 'X') rCnt++
            }
            if (map[j][i] == '.') {
                cNum[j][i] = cCnt
                if (j == n || map[j + 1][i] == 'X') cCnt++
            }
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (map[i][j] == '.') graph[rNum[i][j]].add(cNum[i][j])
        }
    }

    var ans = 0

    for (i in 1..rCnt) {
        Arrays.fill(visited, false)
        if (dfs(i)) ans++
    }

    println(ans)
}
