package baekjoon.gold.g4.마약수사대

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { ArrayList<Int>() }
    val inDegree = IntArray(n)

    repeat(m) {
        val (a, b) = readln().split(" ").map { it[0] - 'A' }
        graph[a].add(b)
        inDegree[b]++
    }

    val isDisable = BooleanArray(n)
    readln().split(" ").drop(1).map { it[0] - 'A' }.forEach { isDisable[it] = true }
    val visited = BooleanArray(n)
    val roots = (0..<n).filter { inDegree[it] == 0 && !isDisable[it] }
    roots.forEach { dfs(it, graph, visited, isDisable) }
    println(visited.count { it } - roots.size)
}

fun dfs(i: Int, graph: Array<ArrayList<Int>>, visited: BooleanArray, disable: BooleanArray) {
    visited[i] = true
    graph[i].filter { !visited[it] && !disable[it] }.forEach { dfs(it, graph, visited, disable) }
}