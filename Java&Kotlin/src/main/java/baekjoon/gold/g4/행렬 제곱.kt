package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nb = br.readLine().split(" ")
    val n = nb[0].toInt()
    val b = nb[1].toInt() // 제곱

    val arr = Array(n) { Array(n) { 0 } }

    repeat(n) { i ->
        val st = StringTokenizer(br.readLine())
        repeat(n) { j ->
            arr[i][j] = st.nextToken().toInt()
        }
    }



}