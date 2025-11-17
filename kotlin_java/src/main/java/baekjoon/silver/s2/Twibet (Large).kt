package baekjoon.silver.s2

fun main() = repeat(readln().toInt()) { caseIdx ->
    val n = readln().toInt()
    val graph = readln().split(" ").map { it.toInt() }

    val reverse = Array(n + 1) { mutableListOf<Int>() }
    for (i in 1..n) {
        val parent = graph[i - 1]
        reverse[parent].add(i)
    }

    println("Case #${caseIdx + 1}:")

    for (k in 1..n) {
        val visited = BooleanArray(n + 1)
        var count = 0

        fun dfs(x: Int) {
            if (visited[x]) return
            visited[x] = true
            count++
            reverse[x].forEach { next -> dfs(next) }
        }

        dfs(k)
        println(count)
    }
}
