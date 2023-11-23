package baekjoon.gold.g4

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val weight = Array(n + 1) { Array(n + 1) { 0 } }
    repeat(m) {
        val (v1, v2) = readLine().split(" ").map { it.toInt() }
        weight[v1][v2] = 1
        weight[v2][v1] = -1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (weight[i][k] != 0 && weight[i][k] == weight[k][j]) {
                    weight[i][j] = weight[i][k]
                }
            }
        }
    }

    val half = (n / 2) + 1
    var cnt = 0

    for (i in 1..n) {
        var bigger = 0
        var smaller = 0

        for (j in 1..n) {
            if (weight[i][j] == 1) bigger++
            if (weight[i][j] == -1) smaller++
        }

        if (bigger >= half || smaller >= half) cnt++
    }

    println(cnt)
}