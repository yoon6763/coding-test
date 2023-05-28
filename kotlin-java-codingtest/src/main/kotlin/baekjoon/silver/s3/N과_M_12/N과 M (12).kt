package baekjoon.silver.s3.N과_M_12

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


lateinit var arr: Array<Int>

var n = 0
var m = 0

val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine()!!.split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    val st = StringTokenizer(br.readLine(), " ")

    arr = Array(n + 1) { 0 }

    for (i in 1..n) {
        arr[i] = st.nextToken().toInt()
    }
    arr = arr.sortedArray()


    dfs(1, 0, "")
    print(sb.toString())
}

fun dfs(idx: Int, len: Int, str: String) {
    if (len == m) {
        sb.append(str).append("\n")
        return
    }

    var temp = 0

    for (i in idx..n) {
        if (temp != arr[i]) {
            temp = arr[i]

            if (len == 0)
                dfs(i, 1, arr[i].toString())
            else
                dfs(i, len + 1, "$str ${arr[i]}")
        }
    }
}