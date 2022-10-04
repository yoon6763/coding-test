package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val MAX_VALUE = 10000000

    val br = BufferedReader(InputStreamReader(System.`in`))

    val nmr = br.readLine().split(" ").map { it.toInt() }
    val n = nmr[0] // 지역 개수
    val m = nmr[1] // 수색 범위
    val r = nmr[2] // 길의 개수

    val items = Array(n + 1) { 0 }
    val weight = Array(n + 1) { Array(n + 1) { MAX_VALUE } }

    val st = StringTokenizer(br.readLine(), " ")

    repeat(n) { items[it + 1] = st.nextToken().toInt() }
    repeat(n) { weight[it + 1][it + 1] = 0 }

    for (i in 1..r) {
        val st2 = StringTokenizer(br.readLine(), " ")
        val v1 = st2.nextToken().toInt()
        val v2 = st2.nextToken().toInt()
        val w = st2.nextToken().toInt()
        weight[v1][v2] = w
        weight[v2][v1] = w
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (weight[i][k] + weight[k][j] < weight[i][j]) {
                    weight[i][j] = weight[i][k] + weight[k][j]
                }
            }
        }
    }

    var max = 0

    for (i in 1..n) {
        var sum = 0

        for (j in 1..n) {
            if (weight[i][j] <= m) {
                sum += items[j]
            }
        }

        if (max < sum) max = sum
    }

    println(max)
}