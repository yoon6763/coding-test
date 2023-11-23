package baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val connection = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        for (j in 0 until n) {
            connection[i][j] = st.nextToken().toInt()
        }
    }


    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (connection[i][k] == 1 && connection[k][j] == 1) {
                    connection[i][j] = 1
                }
            }
        }
    }

    connection.forEach { it1 ->
        it1.forEach { it2 -> print("$it2 ") }
        println()
    }
}