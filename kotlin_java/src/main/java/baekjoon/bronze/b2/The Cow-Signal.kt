package baekjoon.bronze.b2

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val s = Array(n) { readln() }

    for (i in 0..<n * k) {
        for (j in 0..<m * k) {
            print(s[i / k][j / k])
        }
        println()
    }
}
