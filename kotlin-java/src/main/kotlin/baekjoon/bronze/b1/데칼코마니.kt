package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val arr = Array(n) { readln().toCharArray() }

    for (i in 0..<n) {
        for (j in 0..<m / 2) {
            if (arr[i][j] != '.') arr[i][m - j - 1] = arr[i][j]
            if (arr[i][m - j - 1] != '.') arr[i][j] = arr[i][m - j - 1]
        }
    }

    println(arr.joinToString("\n") { it.joinToString("") })
}