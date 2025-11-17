import java.util.*

const val MAX = 1255
const val MAP_SIZE = 55

var graph = Array(MAX) { ArrayList<Int>() }
var leftMatch = IntArray(MAX) { -1 }
var rightMatch = IntArray(MAX) { -1 }
var visited = BooleanArray(MAX)

fun dfs(from: Int): Boolean {
    visited[from] = true
    for (next in graph[from]) {
        if (rightMatch[next] == -1 || (!visited[rightMatch[next]] && dfs(rightMatch[next]))) {
            leftMatch[from] = next
            rightMatch[next] = from
            return true
        }
    }
    return false
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val map = Array(MAP_SIZE) { CharArray(MAP_SIZE) }
    for (i in 1..n) {
        val line = readLine()
        for (j in 1..m) map[i][j] = line[j - 1]
    }

    var cnt = 1
    val rowHole = Array(MAP_SIZE) { IntArray(MAP_SIZE) }
    val colHole = Array(MAP_SIZE) { IntArray(MAP_SIZE) }
    for (i in 1..n) {
        for (j in 1..m) {
            if (map[i][j] == '*') {
                rowHole[i][j] = cnt
                if (j == m || map[i][j + 1] == '.') cnt++
            }
        }
    }
    val rCnt = cnt
    cnt = 1
    for (i in 1..m) {
        for (j in 1..n) {
            if (map[j][i] == '*') {
                colHole[j][i] = cnt
                if (j == n || map[j + 1][i] == '.') cnt++
            }
        }
    }

    for (i in 1..n) {
        for (j in 1..m) {
            if (map[i][j] == '*') graph[rowHole[i][j]].add(colHole[i][j])
        }
    }

    var match = 0
    leftMatch.fill(-1)
    rightMatch.fill(-1)
    for (i in 1..rCnt) {
        visited.fill(false)
        if (dfs(i)) match++
    }

    println(match)
}
