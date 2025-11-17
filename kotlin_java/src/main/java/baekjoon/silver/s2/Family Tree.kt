package baekjoon.silver.s2

fun main() {
    val n = readln().toInt()
    val graph = mutableMapOf<String, MutableList<String>>()
    val root = readln()
    graph[root] = mutableListOf()

    repeat(n - 1) {
        val (parent, child) = readln().split(" - ")
        graph.getOrPut(parent) { mutableListOf() }.add(child)
    }

    var ans = 1
    val q = ArrayDeque<String>()
    q.add(root)

    while (q.isNotEmpty()) {
        ans = ans.coerceAtLeast(q.size)

        repeat(q.size) {
            val cur = q.removeFirst()
            graph[cur]?.forEach { child ->
                q.add(child)
            }
        }
    }

    println(ans)
}