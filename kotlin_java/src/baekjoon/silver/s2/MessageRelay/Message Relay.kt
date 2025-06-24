package baekjoon.silver.s2.MessageRelay

fun main() {
    val n = readln().toInt()
    val graph = intArrayOf(0) + IntArray(n) { readln().toInt() }
    val visited = IntArray(n + 1) { 0 }

    fun dfs(cur: Int, path: MutableList<Int>): Boolean {
        return when (visited[cur]) {
            2 -> false
            3 -> true
            1 -> {
                for (i in path.indexOf(cur) until path.size) visited[path[i]] = 3
                true
            }

            else -> {
                visited[cur] = 1
                path.add(cur)
                val next = graph[cur]
                val isLoop = if (next != 0) dfs(next, path) else false
                if (!isLoop) visited[cur] = 2
                else if (visited[cur] != 3) visited[cur] = 3
                path.removeAt(path.size - 1)
                isLoop
            }
        }
    }

    for (i in 1..n) {
        if (visited[i] != 0) continue
        dfs(i, mutableListOf())
    }

    println(visited.drop(1).count { it != 3 })
}