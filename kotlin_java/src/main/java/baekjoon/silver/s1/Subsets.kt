package baekjoon.silver.s1

fun main() {
    val n = readln().toInt()
    val graph = mutableMapOf<Char, MutableSet<Char>>()

    repeat(n) {
        val (a, _, b) = readln().split(" ").map { it[0] }
        graph.getOrPut(a) { mutableSetOf() }.add(b)
        graph.getOrPut(b) { mutableSetOf() }
    }

    fun dfs(cur: Char, visited: MutableSet<Char>) {
        graph[cur]?.forEach { next ->
            if (next in visited) return@forEach
            visited.add(next)
            dfs(next, visited)
        }
    }

    graph.keys.filter { it.isUpperCase() }.sorted().forEach { root ->
        val visited = mutableSetOf<Char>()
        dfs(root, visited)
        println("$root = {${visited.filter { it.isLowerCase() }.sorted().joinToString(",")}}")
    }
}