package baekjoon.silver.s2.MeetingTime

data class Node(val to: Int, val weight: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val (bessieGraph, elsieGraph) = List(2) { Array(n + 1) { arrayListOf<Node>() } }

    repeat(m) {
        val (a, b, c, d) = readLine().split(" ").map { it.toInt() }
        bessieGraph[a].add(Node(b, c))
        elsieGraph[a].add(Node(b, d))
    }

    val bessieAbleTimes = mutableSetOf<Int>()
    val elsieAbleTimes = mutableSetOf<Int>()

    dfs(bessieGraph, 1, n, 0, bessieAbleTimes)
    dfs(elsieGraph, 1, n, 0, elsieAbleTimes)

    val ableTimes = bessieAbleTimes intersect elsieAbleTimes
    println(if (ableTimes.isEmpty()) "IMPOSSIBLE" else ableTimes.min())
}

fun dfs(graph: Array<ArrayList<Node>>, cur: Int, end: Int, sumDistance: Int, ableTimes: MutableSet<Int>) {
    if (cur == end) {
        ableTimes.add(sumDistance)
        return
    }

    graph[cur].forEach { node ->
        dfs(graph, node.to, end, sumDistance + node.weight, ableTimes)
    }
}