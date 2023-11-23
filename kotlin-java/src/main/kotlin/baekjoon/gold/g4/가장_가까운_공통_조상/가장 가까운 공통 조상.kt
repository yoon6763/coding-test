package baekjoon.gold.g4.가장_가까운_공통_조상

lateinit var tree: Array<ArrayList<Int>>
lateinit var depths: IntArray
lateinit var parents: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        tree = Array(n + 1) { ArrayList() }
        depths = IntArray(n + 1)
        parents = IntArray(n + 1) { -1 }

        repeat(n - 1) {
            val (v1, v2) = readLine().split(" ").map(String::toInt)
            tree[v1].add(v2)
            parents[v2] = v1
        }

        val (v1, v2) = readLine().split(" ").map(String::toInt)
        val root = findRootNode()

        dfs(root, 1, root)

        sb.appendLine(lca(v1, v2))
    }

    print(sb)
}

fun findRootNode(): Int {
    var cur = 1
    while (parents[cur] != -1) {
        cur = parents[cur]
    }
    return cur
}

fun dfs(cur: Int, depth: Int, parent: Int) {
    depths[cur] = depth
    parents[cur] = parent

    tree[cur].forEach { next ->
        if (parent == next) return@forEach
        dfs(next, depth + 1, cur)
    }
}

fun lca(v1: Int, v2: Int): Int {
    var v1 = v1
    var v2 = v2

    var depth1 = depths[v1]
    var depth2 = depths[v2]

    while (depth1 > depth2) {
        depth1--
        v1 = parents[v1]
    }

    while (depth1 < depth2) {
        depth2--
        v2 = parents[v2]
    }

    while (v1 != v2) {
        depth1--
        depth2--
        v1 = parents[v1]
        v2 = parents[v2]
    }

    return v1
}
