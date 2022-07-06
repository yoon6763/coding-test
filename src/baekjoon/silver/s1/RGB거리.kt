package baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = Array(n + 1) { 0 }
    val rgb = Array(n + 1) { arrayOf(0, 0, 0) }

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine(), " ")
        repeat(3) { it2 ->
            rgb[i][it2] = st.nextToken().toInt()
        }
    }
    var result = rgb[1].minOrNull()!!
    dp[1] = rgb[1].indexOf(result)

    for (i in 2..n) {
        var temp = Int.MAX_VALUE

        for(j in 0 .. 2) {
            if(dp[i-1] != j && temp > rgb[i][j]) {
                temp = rgb[i][j]
                dp[i] = j
                result += rgb[i][j]
            }
        }
    }

    println(result)
}