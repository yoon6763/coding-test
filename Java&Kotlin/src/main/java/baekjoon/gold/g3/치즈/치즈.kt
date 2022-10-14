package baekjoon.gold.g3.치즈

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var n = 0
var m = 0
var hour = 0
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)
lateinit var map: Array<Array<Int>>
lateinit var visited: Array<Array<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { Array(m) { 0 } }
    visited = Array(n) { Array(m) { 0 } }

    // 맵 정보 입력
    repeat(n) { x ->
        val st = StringTokenizer(br.readLine())
        repeat(m) { y ->
            map[x][y] = st.nextToken().toInt()
        }
    }

    while (true) {
        var sum = 0
        map.forEach { it.forEach { sum += it } }
        if (sum == 0) break // 맵 모두 치즈가 없으면 break

        dfs(0, 0) // 맵 가장자리는 치즈가 없음

        // 방문횟수가 2 이상인 경우 (치즈 있는 칸을 두 번 이상 접근하거나 치즈가 없는 칸일 경우) 0 으로 변경
        // visited 도 다시 0으로
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (visited[i][j] >= 2) map[i][j] = 0
                visited[i][j] = 0
            }
        }

        hour++
    }

    println(hour)
}


fun dfs(x: Int, y: Int) {
    // 치즈가 있을경우 방문횟수 +1
    if (map[x][y] == 1) {
        visited[x][y]++
        return
    }
    // 치즈가 아닐경우 방문횟수 2로 고정
    visited[x][y] = 2


    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        // 범위를 벗어나는지 검사 / 방문횟수가 2회 이상인지 검사
        if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] >= 2) continue

        dfs(nx, ny)
    }
}