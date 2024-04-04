package baekjoon.bronze.b1

fun main() {
    var cnt = 1
    val (n, m) = readln().split(" ").map { it.toInt() }
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    var direction = 0

    var x = 0
    var y = 0
    var answer = 0
    val visited = Array(n) { BooleanArray(m) }

    while (cnt < n * m) {
        val nx = x + dx[direction]
        val ny = y + dy[direction]

        if (nx !in 0..<n || ny !in 0..<m || visited[nx][ny]) {
            direction = (direction + 1) % 4
            answer++
        } else {
            visited[x][y] = true
            x = nx
            y = ny
            cnt++
        }
    }

    println(answer)
}