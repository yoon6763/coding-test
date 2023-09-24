package programmers.lv3

fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
    val table = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
    repeat(n + 1) {
        table[it][it] = 0
    }

    for (fare in fares) {
        table[fare[0]][fare[1]] = fare[2]
        table[fare[1]][fare[0]] = fare[2]
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (table[i][k] == Int.MAX_VALUE || table[k][j] == Int.MAX_VALUE) continue
                if (table[i][j] > table[i][k] + table[k][j]) table[i][j] = table[i][k] + table[k][j]
            }
        }
    }

    var answer = Int.MAX_VALUE
    for (i in 1..n) {
        if (table[s][i] == Int.MAX_VALUE || table[i][a] == Int.MAX_VALUE || table[i][b] == Int.MAX_VALUE) continue
        answer = minOf(answer, table[s][i] + table[i][a] + table[i][b])
    }

    return answer
}