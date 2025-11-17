package baekjoon.silver.s1

fun main() {
    val n = readln().toInt()

    val mains = mutableListOf<String>()
    val graph = mutableMapOf<String, MutableList<String>>()
    val all = mutableSetOf<String>()

    repeat(n) {
        val childMethod = readln().split(" ")[0]
        all.add(childMethod)

        if ("::PROGRAM" in childMethod) mains.add(childMethod)

        val callersLine = readln().trim()
        if (callersLine.isNotEmpty()) {
            callersLine.split(" ").forEach { parentMethod ->
                graph.getOrPut(parentMethod) { mutableListOf() }.add(childMethod)
                all.add(parentMethod)
            }
        }
    }

    val visited = mutableSetOf<String>()

    fun dfs(cur: String) {
        if (cur in visited) return
        visited.add(cur)
        graph[cur]?.forEach { dfs(it) }
    }

    all.remove("")
    mains.forEach { dfs(it) }

    println((all - visited).size)
}