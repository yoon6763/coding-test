package baekjoon.silver.s1

fun main() {
    data class Node(val x: Int, val y: Int)

    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    val groupSizeList = mutableListOf<MutableList<Node>>()

    fun dfs(x: Int, y: Int, field: MutableList<Node>) {
        if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] != '1') return
        visited[x][y] = true
        field += Node(x, y)
        for (i in 0..<4) dfs(x + dx[i], y + dy[i], field)
    }

    for (i in 0..<n)
        for (j in 0..<m)
            if (!visited[i][j] && map[i][j] == '1') groupSizeList += mutableListOf<Node>().apply { dfs(i, j, this) }

    groupSizeList.sortedBy { it.size }
        .forEachIndexed { day, field -> field.forEach { node -> map[node.x][node.y] = ('1' + day) } }

    println(map.joinToString("\n") { it.joinToString("") })
}
