package baekjoon.bronze.b1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val arr = IntArray(n)
    val st = StringTokenizer(readLine())
    for (i in 0..<n) {
        arr[i] = st.nextToken().toInt()
    }

    var count = 0
    var answer = "-1"

    for (i in n - 1 downTo 1) {
        for (j in 0..<i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                count++
                if (count == k) {
                    answer = arr[j].toString() + " " + arr[j + 1]
                }
            }
        }
    }

    println(answer)
}