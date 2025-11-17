package baekjoon.bronze.b1

fun main() {
    val dx = intArrayOf(-1, 1, 2, 2, 1, -1, -2, -2)
    val dy = intArrayOf(2, 2, 1, -1, -2, -2, -1, 1)

    val map = Array(5) { readln().toCharArray() }
    var cnt = 0

    for (i in 0..<5) {
        for (j in 0..<5) {
            if (map[i][j] == 'k') {
                cnt++
                for (k in 0..<8) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]
                    if (nx in 0..<5 && ny in 0..<5 && map[nx][ny] == 'k') {
                        println("invalid")
                        return
                    }
                }
            }
        }
    }
    println(if (cnt == 9) "valid" else "invalid")
}