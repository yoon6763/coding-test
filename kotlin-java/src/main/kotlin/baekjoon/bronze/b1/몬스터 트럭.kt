package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().toCharArray() }
    val dx = intArrayOf(0, 0, 1, 1)
    val dy = intArrayOf(0, 1, 0, 1)

    val crashCar = Array(5) { 0 }
    for (i in 0..<n - 1) {
        for (j in 0..<m - 1) {
            var crashCount = 0
            var buildingCount = 0

            for (k in 0..<4) {
                val nx = i + dx[k]
                val ny = j + dy[k]

                if (arr[nx][ny] == '#') {
                    buildingCount++
                    break
                }
                if (arr[nx][ny] == 'X') {
                    crashCount++
                }
            }

            if (buildingCount == 0) {
                crashCar[crashCount]++
            }
        }
    }

    println(crashCar.joinToString("\n"))
}