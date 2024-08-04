package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val clouds = Array(n) { readLine().toCharArray() }
    val answer = Array(n) { IntArray(m) { -1 } }

    for (time in 0..<m) {
        for (i in 0..<n) {
            for (j in 0..<m) {
                if (clouds[i][j] == 'c' && answer[i][j] == -1) {
                    answer[i][j] = time
                }
            }
        }

        for (i in 0..<n) {
            for (j in m - 1 downTo 1) {
                clouds[i][j] = clouds[i][j - 1]
            }
        }

        for (i in 0..<n) {
            clouds[i][0] = '.'
        }
    }

    println(answer.joinToString("\n") { it.joinToString(" ") })
}