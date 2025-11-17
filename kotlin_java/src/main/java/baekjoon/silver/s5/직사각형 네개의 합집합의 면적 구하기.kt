package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val square = Array(101) { BooleanArray(101) }

    repeat(4) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        for (i in x1 until x2) for (j in y1 until y2) square[i][j] = true
    }

    println(square.sumOf { it.count { it } })
}