package baekjoon.bronze.b1

fun main() {
    val parse = mapOf('.' to '.', 'O' to 'O', '|' to '-', '-' to '|', '/' to '\\', '\\' to '/', '^' to '<', '<' to 'v', 'v' to '>', '>' to '^')
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().map{ parse[it]?:it } }

    for (i in m - 1 downTo 0) {
        for (j in 0..<n) {
            print(arr[j][i])
        }
        println()
    }
}