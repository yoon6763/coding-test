package baekjoon.gold.g3.DFS스페셜저지

fun main() {
    val n = readln().toInt()
    val adj = Array(n + 1) { mutableListOf<Int>() }

    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        adj[a] += b
        adj[b] += a
    }

    val inputOrder = readln().split(" ").map { it.toInt() }
    val searchedOrder = mutableListOf<Int>()

    if (inputOrder[0] != 1) {
        println(0)
        return
    }

    val position = IntArray(n + 1)
    for (i in inputOrder.indices) {
        position[inputOrder[i]] = i
    }

    adj.forEach { it.sortBy { position[it] } }

    val visited = BooleanArray(n + 1)

    fun dfs(cur: Int) {
        visited[cur] = true
        searchedOrder += cur
        adj[cur].filterNot { visited[it] }.forEach { dfs(it) }
    }

    dfs(1)
    println(if (searchedOrder == inputOrder) 1 else 0)
}
