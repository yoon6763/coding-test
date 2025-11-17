package baekjoon.silver.s2

fun main() {
    val n = readln().split(" ").map { it.toInt() }[0]
    val parents = listOf(-1) + readln().split(" ").map { it.toInt() }
    val peopleInTable = readln().split(" ").map { it.toInt() }.toIntArray()
    val graph = Array(n + 1) { mutableListOf<Int>() }

    for (child in 1..n) graph[parents[child]].add(child)

    val visited = BooleanArray(n + 1)

    fun dfs(cur: Int) {
        graph[cur].forEach { child ->
            if (visited[child]) return@forEach
            visited[child] = true
            dfs(child)
        }
    }

    peopleInTable.forEach { person ->
        if (visited[person]) return@forEach
        dfs(person)
    }

    println(peopleInTable.count { !visited[it] })
}