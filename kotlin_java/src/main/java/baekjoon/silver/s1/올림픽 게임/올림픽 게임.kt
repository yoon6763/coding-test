package baekjoon.silver.s1.`올림픽 게임`

import java.lang.StringBuilder
import java.util.StringTokenizer

data class Game(val day: Int, val start: Int, val end: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val games = Array(n) {
            val st = StringTokenizer(readLine())
            Game(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        }.sortedWith(compareBy({ it.day }, { it.end }))

        var answer = 0

        var day = 0
        var end = 0

        for (i in games.indices) {
            if (games[i].day != day) {
                day = games[i].day
                end = games[i].end
                answer++
            } else {
                if (games[i].start >= end) {
                    end = games[i].end
                    answer++
                }
            }
        }
        sb.append("Scenario #${it + 1}:\n$answer\n\n")
    }
    print(sb)
}