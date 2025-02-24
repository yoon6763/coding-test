package baekjoon.gold.g4.Tree

lateinit var tree: Array<MutableList<Int>>
lateinit var visited: BooleanArray
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        n = readLine().toInt()
        val m = readLine().toInt()

        tree = Array(n + 1) { mutableListOf() }
        visited = BooleanArray(n + 1)

        repeat(m) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            tree[a].add(b)
            tree[b].add(a)
        }

        sb.appendLine(if (!isExistCycle(1, 0) && visited.drop(1).all { it }) "tree" else "graph")
    }

    print(sb)
}

fun isExistCycle(cur: Int, pre: Int): Boolean {
    visited[cur] = true
    tree[cur].forEach { next ->
        if (next == pre) return@forEach
        if (visited[next] || isExistCycle(next, cur)) return true
    }
    return false
}