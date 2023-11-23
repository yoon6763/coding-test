package baekjoon.gold.g4

import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val MAX = 987654321
    val br = System.`in`.bufferedReader()

    val ve = br.readLine().split(" ")
    val v = ve[0].toInt()
    val e = ve[1].toInt()

    val w = Array(v + 1) { Array(v + 1) { MAX } }

    repeat(v + 1) {
        w[it][it] = 0
    }

    repeat(e) {
        val st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val weight = st.nextToken().toInt()
        w[from][to] = weight
    }

    for (k in 1..v) {
        for (i in 1..v) {
            for (j in 1..v) {
                if (w[i][k] + w[k][j] < w[i][j]) {
                    w[i][j] = w[i][k] + w[k][j]
                }
            }
        }
    }

    var result = MAX
    for (i in 1..v) {
        for (j in 1..v) {
            if (i != j && w[i][j] != MAX && w[j][i] != MAX) {
                result = min(result, w[i][j] + w[j][i])
            }
        }
    }
    println(if (result == MAX) -1 else result)
}