package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt() // 도시 개수
    val m = br.readLine().toInt() // 버스 개수

    val connect = Array(n) { Array(n) { Int.MAX_VALUE } }

    repeat(m) {
        val abw = br.readLine().split(" ").map { it.toInt() } // 출발, 도착, 비용
        val a = abw[0] - 1
        val b = abw[1] - 1
        val w = abw[2]

        connect[a][b] = min(connect[a][b], w)
    }
    repeat(n) {
        connect[it][it] = 0
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (connect[i][k] == Int.MAX_VALUE || connect[k][j] == Int.MAX_VALUE) continue
                if (connect[i][j] > connect[i][k] + connect[k][j]) connect[i][j] = connect[i][k] + connect[k][j]
            }
        }
    }

    connect.forEach { it1 ->
        it1.forEach { it2 ->
            print("${if (it2 == Int.MAX_VALUE) 0 else it2} ")
        }
        println()
    }
}