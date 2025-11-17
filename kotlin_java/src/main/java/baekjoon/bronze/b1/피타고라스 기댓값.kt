package baekjoon.bronze.b1

fun main() = repeat(readln().toInt()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val gameScore = MutableList(n) { Pair(0, 0) }
    val w = mutableListOf<Double>()

    repeat(m) {
        var (a, b, p, q) = readln().split(" ").map { it.toInt() }
        a--
        b--
        gameScore[a] = Pair(gameScore[a].first + p, gameScore[a].second + q)
        gameScore[b] = Pair(gameScore[b].first + q, gameScore[b].second + p)
    }

    gameScore.forEach { (score, loss) -> w.add(if (score == 0 && loss == 0) 0.0 else 1000.0 * score * score / (score * score + loss * loss)) }

    println(w.maxOf { it }.toInt())
    println(w.minOf { it }.toInt())
}
