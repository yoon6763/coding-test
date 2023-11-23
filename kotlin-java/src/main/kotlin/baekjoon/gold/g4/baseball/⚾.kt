package baekjoon.gold.g4.baseball

import java.util.*
import kotlin.math.max

lateinit var player: Array<Array<Int>>
val nowPlayer = Array(10) { 0 }
var n = 0
var maxScore = 0
lateinit var visited: Array<Boolean>

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    visited = Array(10) { false }

    player = Array(n) {
        val st = StringTokenizer(readLine())
        Array(10) { if (it == 0) 0 else st.nextToken().toInt() }
    }

    // 1번 선수가 4번 타자
    visited[1] = true
    nowPlayer[4] = 1
    getArray(1)

    println(maxScore)
}


// 순열
fun getArray(depth: Int) {
    when (depth) {
        10 -> gamePlay()
        4 -> getArray(depth + 1)
        else -> {
            for (i in 1..9) {
                if (!visited[i]) {
                    visited[i] = true
                    nowPlayer[depth] = i
                    getArray(depth + 1)
                    visited[i] = false
                }
            }
        }
    }
}


fun gamePlay() {
    var score = 0
    var playerIdx = 0

    for (inning in 0 until n) {
        var outCnt = 0
        val base = Array(3) { false } // 1루 2루 3루

        while (true) {
            if (++playerIdx > 9) playerIdx = 1

            when (player[inning][nowPlayer[playerIdx]]) {
                // 0 - 아웃, 1 - 1칸씩 진루, 2 - 2칸씩 진루, 3 - 3칸씩 진루, 4 - 홈런,
                0 -> if (++outCnt >= 3) break
                1 -> {
                    // 모든 타수는 1칸씩 진루
                    if (base[2]) score++
                    base[2] = base[1]
                    base[1] = base[0]
                    base[0] = true
                }

                2 -> {
                    if (base[2]) score++
                    if (base[1]) score++
                    base[2] = base[0]
                    base[1] = true
                    base[0] = false
                }

                3 -> {
                    score += base.count { it }
                    // 3진루 시 항상 3루는 차있고, 1, 2루는 비어있음
                    base[2] = true
                    base[1] = false
                    base[0] = false
                }

                4 -> {
                    score += base.count { it } + 1
                    // 홈런 시 모든 베이스는 비어있음
                    base.fill(false)
                }
            }
        }
    }

    maxScore = max(maxScore, score)
}