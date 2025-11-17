package baekjoon.silver.s1

fun main() {
    var idx = 1

    while (true) {
        val firstLine = readln().split(" ")
        if (firstLine[0] == "#") break
        val graph = LinkedHashMap<String, String>()
        graph[firstLine[0]] = firstLine[1]

        while (true) {
            val line = readln().split(" ")
            if (line[0] == "#") break
            graph[line[0]] = line[1]
        }

        println("Party number ${idx++}")
        val path = mutableListOf<String>()
        val visited = mutableSetOf<String>()

        fun dfs(node: String) {
            path += node
            visited += node
            val next = graph[node] ?: return
            if (next in visited) return
            dfs(next)
        }

        graph.keys.forEach {
            if (it in visited) return@forEach
            dfs(it)
            println("${path.apply { add(it) }.joinToString(" to ")}.")
            path.clear()
        }

        println()
    }
}
