package baekjoon.gold.g5.`마법사 상어와 비바라기`

import java.util.StringTokenizer

data class Cloud(var x: Int, var y: Int)

val dx = arrayOf(0, 0, -1, -1, -1, 0, 1, 1, 1)
val dy = arrayOf(0, -1, -1, 0, 1, 1, 1, 0, -1)

val crossDx = arrayOf(-1, -1, 1, 1)
val crossDy = arrayOf(-1, 1, -1, 1)

var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    val m = nm[1]

    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    var clouds = arrayListOf(Cloud(n - 1, 0), Cloud(n - 1, 1), Cloud(n - 2, 0), Cloud(n - 2, 1))

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (d, s) = List(2) { st.nextToken().toInt() }

        moveCloud(clouds, d, s)
        rainFall(map, clouds)
        waterCopyBug(map, clouds)
        clouds = makeCloud(map, clouds)
    }

    println(map.sumOf { it.sum() })
}

fun makeCloud(map: Array<IntArray>, prevClouds: ArrayList<Cloud>): ArrayList<Cloud> {
    val newClouds = ArrayList<Cloud>()
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (map[i][j] < 2 || prevClouds.any { it.x == i && it.y == j }) continue
            newClouds.add(Cloud(i, j))
            map[i][j] -= 2
        }
    }

    return newClouds
}

fun waterCopyBug(map: Array<IntArray>, clouds: ArrayList<Cloud>) {
    clouds.forEach { cloud ->
        for (i in 0..<4) {
            val nx = cloud.x + crossDx[i]
            val ny = cloud.y + crossDy[i]

            if (nx !in 0..<n || ny !in 0..<n || map[nx][ny] == 0) continue
            map[cloud.x][cloud.y]++
        }
    }
}


fun rainFall(map: Array<IntArray>, cloud: ArrayList<Cloud>) {
    cloud.forEach { map[it.x][it.y]++ }
}

fun moveCloud(cloud: ArrayList<Cloud>, d: Int, s: Int) {
    for (i in cloud.indices) {
        cloud[i].x = (cloud[i].x + dx[d] * s) % n
        cloud[i].y = (cloud[i].y + dy[d] * s) % n

        while (cloud[i].x < 0) cloud[i].x += n
        while (cloud[i].y < 0) cloud[i].y += n
    }
}
