package baekjoon.silver.s2.숫자판점프

lateinit var map: Array<Array<Int>>
val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)
val path = Array(6) { "" }
val set = mutableSetOf<String>()

fun main() = with(System.`in`.bufferedReader()) {
    map = Array(5) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            dfs(i, j, 0)
        }
    }
    println(set.size)
}

fun dfs(x: Int, y: Int, depth: Int) {
    if (depth == 6) {
        set.add(path.joinToString(""))
        return
    }

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in 0 until 5 || ny !in 0 until 5) continue
        path[depth] = map[nx][ny].toString()
        dfs(nx, ny, depth + 1)
    }
}