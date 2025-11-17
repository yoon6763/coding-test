package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln() }
    val result = Array(n * 2) { CharArray(m * 2) }
    for (i in 0..<n) {
        for (j in 0..<m) {
            result[i][j] = arr[i][j]
            result[i][m * 2 - j - 1] = arr[i][j]
            result[n * 2 - i - 1][j] = arr[i][j]
            result[n * 2 - i - 1][m * 2 - j - 1] = arr[i][j]
        }
    }
    val (errorX, errorY) = readln().split(" ").map { it.toInt() }
    result[errorX - 1][errorY - 1] = if (result[errorX - 1][errorY - 1] == '#') '.' else '#'
    result.forEach { println(it.joinToString("")) }
}