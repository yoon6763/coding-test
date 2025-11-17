package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    for (i in 0..<n) {
        for (j in 0..<n) {
            when {
                i == 0 || j == 0 || i == n - 1 || j == n - 1 -> print("*")
                i == j || i + j == n - 1 -> print("*")
                else -> print(" ")
            }
        }
        println()
    }
}
