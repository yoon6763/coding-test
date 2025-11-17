package baekjoon.silver.s2.Gruppindelning

fun main() {
    val n = readln().toInt()
    val members = Array(n) { readln() }
    val graph = HashMap<String, ArrayList<String>>()

    repeat(readln().toInt()) {
        val (from, to) = readln().split(" ")
        graph.computeIfAbsent(from) { ArrayList() }.add(to)
        graph.computeIfAbsent(to) { ArrayList() }.add(from)
    }

    val visited = HashSet<String>()
    var groupCount = 0
    members.forEach { member ->
        if (member in visited) return@forEach
        visited.add(member)
        dfs(member, graph, visited)
        groupCount++
    }

    println(groupCount)
}

fun dfs(cur: String, graph: HashMap<String, ArrayList<String>>, visited: HashSet<String>) {
    graph[cur]?.forEach { next ->
        if (next in visited) return@forEach
        visited.add(next)
        dfs(next, graph, visited)
    }
}