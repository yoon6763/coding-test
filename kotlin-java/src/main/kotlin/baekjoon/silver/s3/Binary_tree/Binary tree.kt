package baekjoon.silver.s3.Binary_tree

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    graph = Array(n) { ArrayList() }
    visited = IntArray(n)

    var root = -1

    for (childNode in 0..<n) {
        val parentNode = readLine().toInt()
        if (parentNode == -1) {
            root = childNode
            continue
        }

        graph[parentNode - 1].add(childNode)
    }

    dfs(root, 0)
    print(visited.joinToString(" "))
}

fun dfs(cur: Int, depth: Int) {
    visited[cur] = depth

    graph[cur].forEach {
        if (visited[it] != 0) return@forEach
        dfs(it, depth + 1)
    }
}