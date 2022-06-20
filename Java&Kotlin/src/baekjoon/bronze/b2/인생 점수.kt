package baekjoon.bronze.b2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    repeat(n) {
        var score = 0
        val line = br.readLine().replace(" ", "")

        for (i in line.indices) score += line[i] - 'A' + 1

        println(if (score == 100) "PERFECT LIFE" else score)
    }
}