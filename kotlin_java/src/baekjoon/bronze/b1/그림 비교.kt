package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { Array(5) { readLine() } }

    var min = Int.MAX_VALUE
    var answer = 1 to 2

    for (i in 0..<n) {
        for (j in i + 1..<n) {
            var cnt = 0
            for (x in 0..<5) {
                for (y in 0..<7) {
                    if (arr[i][x][y] != arr[j][x][y]) {
                        cnt++
                    }
                }
            }

            if (cnt < min) {
                min = cnt
                answer = i + 1 to j + 1
            }
        }
    }

    println("${answer.first} ${answer.second}")
}