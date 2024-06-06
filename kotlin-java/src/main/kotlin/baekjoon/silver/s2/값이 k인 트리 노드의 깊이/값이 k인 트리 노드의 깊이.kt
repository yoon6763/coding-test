package baekjoon.silver.s2.`값이 k인 트리 노드의 깊이`

import java.util.*

lateinit var tree: Array<ArrayList<Int>>
lateinit var depthArr: IntArray
var n = 0
var k = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nk = readLine().split(" ").map { it.toInt() }
    n = nk[0]
    k = nk[1]
    tree = Array(n + 1) { ArrayList() }
    depthArr = IntArray(n + 1) { -1 }

    repeat(n - 1) {
        val (parent, child) = readLine().split(" ").map { it.toInt() }
        tree[parent].add(child)
    }

    dfs(0, 0)

    val st = StringTokenizer(readLine())
    repeat(n) {
        if (st.nextToken().toInt() == k) {
            println(depthArr[it])
            return
        }
    }
}

fun dfs(cur: Int, depth: Int) {
    depthArr[cur] = depth
    tree[cur].forEach { next ->
        if (depthArr[next] != -1) return@forEach
        dfs(next, depth + 1)
    }
}