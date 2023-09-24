package baekjoon.gold.g5

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    repeat(n) {
        arr[it][it] = 0
    }

    while (true) {
        val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
        if (a == -2 && b == -2) break

        arr[a][b] = 1
        arr[b][a] = 1
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (arr[i][k] == Int.MAX_VALUE || arr[k][j] == Int.MAX_VALUE) continue
                if (arr[i][j] > arr[i][k] + arr[k][j]) arr[i][j] = arr[i][k] + arr[k][j]
            }
        }
    }

    val scores = IntArray(n)
    var min = Int.MAX_VALUE
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] == Int.MAX_VALUE) continue
            scores[i] = maxOf(scores[i], arr[i][j])
        }
        min = minOf(min, scores[i])
    }

    val candidates = mutableListOf<Int>()
    for (i in 0 until n) {
        if (scores[i] == min) candidates.add(i + 1)
    }

    println("$min ${candidates.size}")
    println(candidates.joinToString(" "))
}