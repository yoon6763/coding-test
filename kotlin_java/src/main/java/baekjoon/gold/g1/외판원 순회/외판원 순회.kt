package baekjoon.gold.g1.`외판원 순회`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min


var n = 0
var targetBit = 0
var INF = 987654321
lateinit var weight: Array<Array<Int>>
lateinit var dp: Array<Array<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()

    targetBit = (1 shl n) - 1
    weight = Array(n) { Array(n) { 0 } }
    dp = Array(n) { Array(targetBit) { -1 } }

    var st: StringTokenizer

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until n) {
            weight[i][j] = st.nextToken().toInt()
        }
    }

    println(dfs(0, 1))
}

fun dfs(cityIdx: Int, bit: Int): Int {
    if (bit == targetBit) {
        return if (weight[cityIdx][0] == 0) INF else weight[cityIdx][0]
    }

    if (dp[cityIdx][bit] != -1) return dp[cityIdx][bit]
    dp[cityIdx][bit] = INF

    for (i in 0 until n) {
        if (weight[cityIdx][i] == 0 || bit and (1 shl i) != 0) continue
        dp[cityIdx][bit] = min(dp[cityIdx][bit], dfs(i, bit or (1 shl i)) + weight[cityIdx][i])
    }

    return dp[cityIdx][bit]
}


/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
 */
