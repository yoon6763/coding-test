package baekjoon.silver.s1.`나무 탈출`

import java.util.*

lateinit var tree: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
var n = 0
var ans = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    tree = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)

    repeat(n - 1) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = st.nextToken().toInt() to st.nextToken().toInt()
        tree[v1].add(v2)
        tree[v2].add(v1)
    }

    dfs(1, 1)

    println(if (ans % 2 == 0) "No" else "Yes")
}

fun dfs(cur: Int, depth: Int) {
    visited[cur] = true

    if (tree[cur].size == 1 && cur != 1) {
        ans += depth - 1
        return
    }

    tree[cur].forEach { next ->
        if (visited[next]) return@forEach
        dfs(next, depth + 1)
    }
}