package baekjoon.gold.g3.`서울 지하철 2호선`

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: Array<Boolean>
lateinit var cycle: Array<Boolean>
var cyclePoint = -1
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    graph = Array(n + 1) { ArrayList() }
    repeat(n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    visited = Array(n + 1) { false }
    cycle = Array(n + 1) { false }

    findCycleUsingDFS(1, -1)
    val answer = Array(n) { findShortestPathUsingBFS(it + 1) }
    println(answer.joinToString(" "))
}

fun findCycleUsingDFS(cur: Int, parent: Int): Boolean {
    visited[cur] = true

    graph[cur].forEach { next ->
        if (next == parent) {
            return@forEach
        }

        if (visited[next]) {
            cyclePoint = next
            cycle[cur] = true
            return true
        }

        if (!visited[next]) {
            visited[next] = true
            if (findCycleUsingDFS(next, cur)) {
                cycle[cur] = true
                return cur != cyclePoint
            }
        }
    }

    return false
}

fun findShortestPathUsingBFS(start: Int): Int {
    if(cycle[start]) return 0

    val q = ArrayDeque<Int>()
    val dist = Array(n + 1) { 0 }
    q.add(start)
    dist[start] = 0

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        graph[cur].forEach { next ->
            if (dist[next] != 0) return@forEach
            dist[next] = dist[cur] + 1
            q.add(next)

            if (cycle[next]) {
                return dist[next]
            }
        }
    }

    return -1
}