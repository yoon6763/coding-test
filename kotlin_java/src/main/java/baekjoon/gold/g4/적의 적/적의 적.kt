package baekjoon.gold.g4.`적의 적`

lateinit var enemy: Array<MutableList<Int>>
lateinit var visited: IntArray

var isAble = true

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    enemy = Array(n + 1) { mutableListOf() }
    visited = IntArray(n + 1)

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        enemy[a].add(b)
        enemy[b].add(a)
    }

    for (i in 1..n) {
        if (visited[i] == 0) {
            dfs(i, 1)
        }
    }

    println(if (isAble) 1 else 0)
}

fun dfs(cur: Int, team: Int) {
    visited[cur] = team

    for(next in enemy[cur]) {
        if (visited[next] == team) {
            isAble = false
            return
        }
        if (visited[next] == 0) {
            dfs(next, -team)
        }
    }
}