package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val arr = Array(n) { Array(3) { 0 } }

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(3) { y ->
            arr[x][y] = st.nextToken().toInt()
        }
    }

    val maxDP = Array(n) { Array(3) { 0 } }
    val minDP = Array(n) { Array(3) { 0 } }
    maxDP[0][0] = arr[0][0]
    maxDP[0][1] = arr[0][1]
    maxDP[0][2] = arr[0][2]
    minDP[0][0] = arr[0][0]
    minDP[0][1] = arr[0][1]
    minDP[0][2] = arr[0][2]

    for (i in 1 until n) {
        maxDP[i][0] = arr[i][0] + max(maxDP[i - 1][0], maxDP[i - 1][1])
        maxDP[i][1] = arr[i][1] + max(maxDP[i - 1][0], max(maxDP[i - 1][1], maxDP[i - 1][2]))
        maxDP[i][2] = arr[i][2] + max(maxDP[i - 1][1], maxDP[i - 1][2])

        minDP[i][0] = arr[i][0] + min(minDP[i - 1][0], minDP[i - 1][1])
        minDP[i][1] = arr[i][1] + min(minDP[i - 1][0], min(minDP[i - 1][1], minDP[i - 1][2]))
        minDP[i][2] = arr[i][2] + min(minDP[i - 1][1], minDP[i - 1][2])
    }

    print("${maxDP[n - 1].maxOrNull()!!} ${minDP[n - 1].minOrNull()!!}")
}