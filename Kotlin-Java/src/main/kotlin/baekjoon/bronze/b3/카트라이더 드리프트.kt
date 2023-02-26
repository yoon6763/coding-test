package baekjoon.bronze.b3

import java.util.*

data class Score(val m: Int, val s: Int, val sss: Int, val team: String)

fun main() = with(System.`in`.bufferedReader()) {
    var rScore = 0
    var bScore = 0

    val scores = ArrayList<Score>()

    repeat(8) {
        val st = StringTokenizer(readLine(), ": ") // : 기준, 공백기준 분리
        scores.add(Score(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken()))
    }

    val scoreVal = arrayOf(10, 8, 6, 5, 4, 3, 2, 1)

    val sorted = scores.sortedWith(compareBy({ it.m }, { it.s }, { it.sss }))

    repeat(8) {
        if (sorted[it].team == "R") rScore += scoreVal[it] else bScore += scoreVal[it]
    }

    if (rScore > bScore) println("Red") else println("Blue")
}