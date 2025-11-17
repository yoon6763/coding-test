package baekjoon.silver.s4

fun main() {
    val (n, newScore, p) = readln().split(" ").map { it.toLong() }
    if (n == 0L) {
        println(1)
        return
    }
    val score = readln().split(" ").map { it.toLong() }

    if (n == p && newScore <= score.last()) {
        println(-1)
        return
    }

    var answer = 1
    for (i in score.indices) {
        if (newScore < score[i]) {
            answer++
        } else {
            break
        }
    }
    println(answer)
}