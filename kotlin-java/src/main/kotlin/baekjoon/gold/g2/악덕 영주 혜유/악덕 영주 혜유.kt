package baekjoon.gold.g2.`악덕 영주 혜유`

import java.util.StringTokenizer

data class EdgeForMST(val from: Int, val to: Int, val cost: Int)
data class EdgeForDFS(val to: Int, val cost: Int)

lateinit var parent: IntArray
lateinit var graph: Array<ArrayList<EdgeForDFS>>
lateinit var visited: BooleanArray

var maxDistance = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n) { it }
    graph = Array(n) { ArrayList() }
    visited = BooleanArray(n)

    val edges = mutableListOf<EdgeForMST>()

    repeat(k) {
        val (from, to, cost) = StringTokenizer(readLine()).let { st -> List(3) { st.nextToken().toInt() } }
        edges.add(EdgeForMST(from, to, cost))
    }
    edges.sortBy { it.cost }

    var sum = 0

    edges.forEach { (from, to, cost) ->
        if (union(from, to)) {
            sum += cost
            graph[from].add(EdgeForDFS(to, cost))
            graph[to].add(EdgeForDFS(from, cost))
        }
    }

    println(sum)
    for (i in 0..<n) {
        visited.fill(false)
        visited[i] = true
        dfs(i, 0)
    }
    println(maxDistance)
}

fun dfs(cur: Int, cost: Int) {
    maxDistance = maxOf(maxDistance, cost)

    graph[cur].forEach { next ->
        if (visited[next.to]) return@forEach
        visited[next.to] = true
        dfs(next.to, cost + next.cost)
    }
}


fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    if (px == py) return false
    if (px < py) parent[py] = px
    else parent[px] = py
    return true
}