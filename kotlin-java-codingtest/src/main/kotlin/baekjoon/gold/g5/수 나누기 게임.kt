package baekjoon.gold.g5

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val MAX_LENGTH = 1000001
    val n = readLine().toInt()

    val st = StringTokenizer(readLine())
    val players = Array(n) { 0 }
    val exist = Array(MAX_LENGTH) { false }

    for (i in 0 until st.countTokens()) {
        players[i] = st.nextToken().toInt()
        exist[players[i]] = true
    }

    val score = Array(MAX_LENGTH) { 0 }
    players.forEach { player ->
        for (i in player * 2 until MAX_LENGTH step player) {
            if (exist[i]) {
                score[i]--
                score[player]++
            }
        }
    }

    val sb = StringBuilder()
    for (i in 0 until n) {
        sb.append(score[players[i]]).append(" ")
    }

    println(sb)
}