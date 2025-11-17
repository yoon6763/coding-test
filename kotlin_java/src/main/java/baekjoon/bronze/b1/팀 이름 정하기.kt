package baekjoon.bronze.b1

fun main() {
    val yeondu = readln().trim().toList()
    val scoreBoard = mutableMapOf<String, Int>()

    repeat(readln().toInt()) {
        val team = readln()
        var nowScore = 1
        val scores = listOf('L', 'O', 'V', 'E').map { name -> team.count { it == name } + yeondu.count { it == name } }

        for (i in scores.indices) {
            for (j in i + 1..<scores.size) {
                nowScore *= (scores[i] + scores[j])
            }
        }

        scoreBoard[team] = nowScore % 100
    }

    println(scoreBoard.toList().sortedWith(compareBy({ -it.second }, { it.first }))[0].first)
}
