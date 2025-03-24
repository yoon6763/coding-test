package baekjoon.bronze.b1

fun main() {
    val scores = Array(3) { intArrayOf(0, 0, 0, it + 1) }
    fun IntArray.sum() = this[0] + this[1] * 2 + this[2] * 3
    repeat(readln().toInt()) {
        val (a, b, c) = readln().split(" ").map { it.toInt() - 1 }
        scores[0][a]++
        scores[1][b]++
        scores[2][c]++
    }
    scores.sortWith(compareBy({ it.sum() }, { it[2] }, { it[1] }))
    println("${if (scores[2].sum() == scores[1].sum() && scores[2][2] == scores[1][2] && scores[2][1] == scores[1][1]) 0 else scores[2][3]} ${scores[2].sum()}")
}