package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { readLine() }
    var vertical = 0
    var horizontal = 0

    for (i in 0 until n) {
        var count = 0
        for (j in 0 until n) {
            if (arr[i][j] == '.') {
                count++
            } else {
                if (count >= 2) {
                    horizontal++
                }
                count = 0
            }
        }
        if (count >= 2) {
            horizontal++
        }
    }

    for (i in 0 until n) {
        var count = 0
        for (j in 0 until n) {
            if (arr[j][i] == '.') {
                count++
            } else {
                if (count >= 2) {
                    vertical++
                }
                count = 0
            }
        }
        if (count >= 2) {
            vertical++
        }
    }

    println("$horizontal $vertical")
}