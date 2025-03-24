package baekjoon.gold.g2.Maaaaaaaaaze

val dx = intArrayOf(0, 0, 0, 0, 1, -1)
val dy = intArrayOf(0, 0, 1, -1, 0, 0)
val dz = intArrayOf(1, -1, 0, 0, 0, 0)
var min = Int.MAX_VALUE
const val n = 5

fun main() = with(System.`in`.bufferedReader()) {
    val map = Array(n) { Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() } }
    floorRotateSearch(0, map)
    println(if (min == Int.MAX_VALUE) -1 else min)
}

fun floorRotateSearch(depth: Int, map: Array<Array<IntArray>>) {
    if (depth == 5) {
        val copiedMap = Array(n) { x -> Array(n) { y -> IntArray(n) { z -> map[x][y][z] } } }
        floorStackSearch(0, BooleanArray(5), map, copiedMap)
        return
    }

    for (i in 0..4) {
        floorRotate(map, depth)
        floorRotateSearch(depth + 1, map)
    }
}

fun floorStackSearch(depth:Int, visited:BooleanArray, originMap: Array<Array<IntArray>>, copiedMap: Array<Array<IntArray>>) {
    if(depth == 5) {
        if(copiedMap[0][0][0] == 0 || copiedMap[4][4][4] == 0) return
        min = minOf(min, bfs(copiedMap))
        return
    }

    for(i in 0 until 5) {
        if(visited[i]) continue

        visited[i] = true
        copiedMap[depth] = originMap[i].copyOf()
        floorStackSearch(depth+1, visited, originMap, copiedMap)
        visited[i] = false
    }
}

fun bfs(map: Array<Array<IntArray>>): Int {
    val visited = Array(n) { Array(n) { IntArray(n) } }
    val queue = ArrayDeque<Triple<Int, Int, Int>>()

    queue.addFirst(Triple(0, 0, 0))
    visited[0][0][0] = 1

    while (queue.isNotEmpty()) {
        val target = queue.removeLast()

        for (i in 0 until 6) {
            val nx = target.first + dx[i]
            val ny = target.second + dy[i]
            val nz = target.third + dz[i]

            if (nx !in 0 until n || ny !in 0 until n || nz !in 0 until n ||
                map[nx][ny][nz] == 0 || visited[nx][ny][nz] != 0
            ) continue

            if (nx == 4 && ny == 4 && nz == 4) return visited[target.first][target.second][target.third]

            visited[nx][ny][nz] = visited[target.first][target.second][target.third] + 1
            queue.addFirst(Triple(nx, ny, nz))
        }
    }

    return Int.MAX_VALUE
}

fun floorRotate(map: Array<Array<IntArray>>, floor: Int) {
    val temp = Array(n) { x -> IntArray(n) { y -> map[floor][x][y] } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            map[floor][i][j] = temp[n - 1 - j][i]
        }
    }
}