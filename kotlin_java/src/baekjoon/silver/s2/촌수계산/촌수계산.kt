package baekjoon.silver.s2.촌수계산

import java.util.*

lateinit var visited: Array<Boolean>
lateinit var connected: Array<ArrayList<Int>>
var cnt = -1

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    visited = Array(n + 1) { false }
    connected = Array(n + 1) { ArrayList<Int>() }

    val (target1, target2) = readLine().split(" ").map { it.toInt() }

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val p1 = st.nextToken().toInt()
        val p2 = st.nextToken().toInt()

        connected[p1].add(p2)
        connected[p2].add(p1)
    }

    visited[target1] = true

    dfs(target1, 0, target2)

    println(cnt)
}


fun dfs(idx: Int, depth: Int, target: Int) {
    if (idx == target) {
        cnt = depth
        return
    }

    for (nextIdx in connected[idx]) {
        if (!visited[nextIdx]) {
            visited[nextIdx] = true
            dfs(nextIdx, depth + 1, target)
        }
    }
}