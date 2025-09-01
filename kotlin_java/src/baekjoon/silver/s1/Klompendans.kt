package baekjoon.silver.s1

fun main() {
    data class Node(val x: Int, val y: Int)

    val n = readln().toInt()
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }

    val moves = { dx: Int, dy: Int ->
        listOf(Node(dx, dy), Node(dx, -dy), Node(-dx, dy), Node(-dx, -dy), Node(dy, dx), Node(dy, -dx), Node(-dy, dx), Node(-dy, -dx))
    }

    val delta1 = moves(a, b)
    val delta2 = moves(c, d)

    val visited = Array(n) { Array(n) { BooleanArray(2) } }

    fun dfs(x: Int, y: Int, turn: Int) {
        if (x !in 0..<n || y !in 0..<n || visited[x][y][turn]) return
        visited[x][y][turn] = true
        (if (turn == 0) delta1 else delta2).forEach { delta -> dfs(x + delta.x, y + delta.y, 1 - turn) }
    }

    dfs(0, 0, 0)
    dfs(0, 0, 1)

    println(visited.flatten().count { it[0] || it[1] })
}
