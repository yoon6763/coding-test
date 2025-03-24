package baekjoon.gold.g3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val table = Array(n + 1) { IntArray(n + 1) { 987654321 } }
    val first = Array(n + 1) { IntArray(n + 1) }

    repeat(n + 1) {
        table[it][it] = 0
    }

    repeat(m) {
        val (v1, v2, weight) = readLine().split(" ").map { it.toInt() }
        table[v1][v2] = weight
        table[v2][v1] = weight
        first[v1][v2] = v2
        first[v2][v1] = v1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (table[i][j] > table[i][k] + table[k][j]) {
                    table[i][j] = table[i][k] + table[k][j]
                    first[i][j] = first[i][k]
                }
            }
        }
    }

    print(first.drop(1).joinToString("\n") { it.drop(1).joinToString(" ") { if (it == 0) "-" else it.toString() } })
}