package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().toCharArray() }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (arr[i][j] == 'S') {
                for (k in 0..<4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]
                    if (nx in 0..<n && ny in 0..<m) {
                        if (arr[nx][ny] == 'W') {
                            println(0)
                            return
                        }
                        if (arr[nx][ny] == '.') {
                            arr[nx][ny] = 'D'
                        }
                    }
                }
            }
        }
    }

    println(1)
    arr.forEach {
        println(it.joinToString(""))
    }
}