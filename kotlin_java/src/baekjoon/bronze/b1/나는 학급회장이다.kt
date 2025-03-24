package baekjoon.bronze.b1

fun main() {
    data class Candidate(
        var score3: Int = 0,
        var score2: Int = 0,
        var score1: Int = 0,
        val index: Int
    ) {
        fun sum() = score3 + score2 + score1
    }

    val n = readln().toInt()
    val a = Candidate(index = 1)
    val b = Candidate(index = 2)
    val c = Candidate(index = 3)

    fun addScore(candidate: Candidate, score: Int) {
        when (score) {
            1 -> candidate.score1++
            2 -> candidate.score2 += 2
            3 -> candidate.score3 += 3
        }
    }

    repeat(n) {
        val (scoreA, scoreB, scoreC) = readln().split(" ").map { it.toInt() }
        addScore(a, scoreA)
        addScore(b, scoreB)
        addScore(c, scoreC)
    }


    val candidates = listOf(a, b, c).sortedWith(compareBy({ it.sum() }, { it.score3 }, { it.score2 }))

    if (candidates[0].sum() == candidates[1].sum() && candidates[0].score3 == candidates[1].score3 && candidates[0].score2 == candidates[1].score2) {
        println("0 ${candidates[0].sum()}")
    } else {
        println("${candidates[0].index} ${candidates[0].sum()}")
    }
}