package baekjoon.platinum.p3.`록 어택`

import java.util.*
import kotlin.collections.map

var match = IntArray(301) { -1 }
var visited = BooleanArray(301)
var map = Array(301) { BooleanArray(301) { true } }

var r = 0
var c = 0

fun dfs(cur: Int): Boolean {
    for (next in 1..c) {
        if (!map[cur][next] || visited[next]) continue
        visited[next] = true
        if (match[next] == -1 || dfs(match[next])) {
            match[next] = cur
            return true
        }
    }

    return false
}

fun main() = with(System.`in`.bufferedReader()) {
    val rcn = readLine().split(" ").map { it.toInt() }
    r = rcn[0]
    c = rcn[1]
    val n = rcn[2]

    repeat(n) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        map[x][y] = false
    }

    var ans = 0

    for (i in 1..r) {
        Arrays.fill(visited, false)
        if (dfs(i)) ans++
    }

    println(ans)
}