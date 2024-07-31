package baekjoon.gold.g5.`트리와 쿼리`

lateinit var tree: Array<MutableList<Int>>
lateinit var countOfChildNode: IntArray
lateinit var visited: BooleanArray
var n = 0
var root = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nrq = readLine().split(" ").map { it.toInt() }
    n = nrq[0]
    root = nrq[1]

    tree = Array(n + 1) { mutableListOf() }
    countOfChildNode = IntArray(n + 1) { 1 }
    visited = BooleanArray(n + 1)

    repeat(n - 1) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        tree[u].add(v)
        tree[v].add(u)
    }

    dfs(root)

    val sb = StringBuilder()

    repeat(nrq[2]) {
        val node = readLine().toInt()
        sb.append(countOfChildNode[node]).append("\n")
    }

    print(sb)
}

fun dfs(cur: Int) {
    visited[cur] = true

    if (tree[cur].size == 1 && cur != root) {
        countOfChildNode[cur] = 1
        return
    }

    tree[cur].forEach { next ->
        if (visited[next]) return@forEach
        dfs(next)
        countOfChildNode[cur] += countOfChildNode[next]
    }
}