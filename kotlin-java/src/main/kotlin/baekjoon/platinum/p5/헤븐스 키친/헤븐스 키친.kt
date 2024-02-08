package baekjoon.platinum.p5.`헤븐스 키친`

import java.util.StringTokenizer
import kotlin.math.abs

data class Node(val x: Int, val y: Int, val cost: Long)

lateinit var parent: IntArray
lateinit var visited: BooleanArray
lateinit var connect: Array<ArrayList<Int>>
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    parent = IntArray(n) { it }
    visited = BooleanArray(n)
    connect = Array(n) { arrayListOf() }

    val chefs = Array<LongArray?>(n) { null }
    var st: StringTokenizer
    repeat(n) {
        st = StringTokenizer(readLine())
        chefs[it] = longArrayOf(st.nextToken().toLong(), st.nextToken().toLong())
    }

    val edgeList = mutableListOf<Node>()

    for (i in 0..<n) {
        for (j in i + 1..<n) {
            val (pi, ci) = chefs[i]!!
            val (pj, cj) = chefs[j]!!
            val cost = (ci + cj) / abs(pi - pj)
            edgeList.add(Node(i, j, cost))
        }
    }

    var sum = 0L
    edgeList.sortedBy { -it.cost }.forEach { (x, y, cost) ->
        if (union(x, y)) {
            sum += cost
            connect[x].add(y)
            connect[y].add(x)
        }
    }

    sb.appendLine(sum)
    dfs(0)
    print(sb)
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    if (px == py) return false
    parent[py] = px
    return true
}

fun dfs(cur: Int) {
    visited[cur] = true

    for (next in connect[cur]) {
        if (!visited[next]) {
            dfs(next)
            sb.appendLine("${cur + 1} ${next + 1}")
        }
    }
}