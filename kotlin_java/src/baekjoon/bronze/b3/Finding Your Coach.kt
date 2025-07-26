package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val (l, r, n, m) = readln().split(" ").map { it.toLong() }

        val ascLeft = n - l
        val ascRight = n + r
        val descLeft = n - r
        val descRight = n + l

        val isAsc = m in ascLeft..ascRight
        val isDesc = m in descLeft..descRight

        if (m == n) {
            println("G")
        } else if (!isAsc) {
            if (m < n) println("R") else println("L")
        } else if (!isDesc) {
            if (m < n) println("L") else println("R")
        } else {
            println("E")
        }
    }
}
