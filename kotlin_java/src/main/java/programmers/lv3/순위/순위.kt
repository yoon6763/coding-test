package programmers.lv3.순위

fun solution(n: Int, results: Array<IntArray>): Int {
    val INF = 100000000
    val table = Array(n + 1) { IntArray(n + 1) { INF } }
    repeat(n + 1) {
        table[it][it] = 0
    }

    for (result in results) {
        table[result[0]][result[1]] = 1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (table[i][k] == INF || table[k][j] == INF) continue
                if (table[i][j] > table[i][k] + table[k][j]) table[i][j] = table[i][k] + table[k][j]
            }
        }
    }

    var answer = 0
    for (i in 1..n) {
        var count = 0
        for (j in 1..n) {
            if (table[i][j] != INF || table[j][i] != INF) count++
        }
        if (count == n) answer++
    }

    return answer
}