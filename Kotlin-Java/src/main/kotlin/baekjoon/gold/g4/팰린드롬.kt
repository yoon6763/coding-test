package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val arr = Array(n) { 0 }
    val st = StringTokenizer(br.readLine())
    repeat(n) {
        arr[it] = st.nextToken().toInt()
    }

    val T = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val se = br.readLine().split(" ")
        var start = se[0].toInt() - 1
        var end = se[1].toInt() - 1

        var isAble = true

        while (start <= end) {
            if(arr[start] != arr[end]) {
                isAble = false
                break
            }
            start++
            end--
        }
        sb.append("${if(isAble) 1 else 0}\n")
    }

    print(sb)
}