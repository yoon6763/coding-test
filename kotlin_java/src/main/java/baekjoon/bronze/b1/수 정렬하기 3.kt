package baekjoon.bronze.b1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()
    val arr = Array(10001) { 0 }

    for (i in 0..<case) {
        arr[br.readLine().toInt()]++
    }

    br.close()

    val sb = StringBuilder()

    for (i in 1..<10001) {
        for (j in 0..<arr[i])
            sb.append(i).append("\n")
    }
    print(sb.toString())
}