package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var n = 0
var b = 0L
lateinit var arr: Array<Array<Int>>
lateinit var answer: Array<Array<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val nb = br.readLine().split(" ")
    n = nb[0].toInt()
    b = nb[1].toLong() // 제곱

    arr = Array(n) { Array(n) { 0 } }
    answer = Array(n) { Array(n) { 0 } }

    repeat(n) { i ->
        val st = StringTokenizer(br.readLine())
        repeat(n) { j ->
            arr[i][j] = st.nextToken().toInt()
        }
        answer[i][i] = 1
    }


    while (b > 0) {
        if (b % 2 == 1L) {
            answer = matrixMultiply(answer, arr)
        }
        arr = matrixMultiply(arr, arr)
        b /= 2
    }


    val sb = StringBuilder()
    answer.forEach { it ->
        it.forEach { it2 ->
            sb.append("$it2 ")
        }
        sb.append("\n")
    }
    print(sb)
}



fun matrixMultiply(m1: Array<Array<Int>>, m2: Array<Array<Int>>): Array<Array<Int>> {
    val resultArr = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                resultArr[i][j] += m1[i][k] * m2[k][j]
                resultArr[i][j] %= 1000
            }
        }
    }
    return resultArr
}