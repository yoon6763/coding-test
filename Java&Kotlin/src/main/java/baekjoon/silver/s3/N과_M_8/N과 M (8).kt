package baekjoon.silver.s3.N과_M_8

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


lateinit var visited: Array<Boolean>
lateinit var arr: Array<Int>

var n = 0
var m = 0

val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine()!!.split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    val st = StringTokenizer(br.readLine()," ")

    arr = Array(n + 1) { 0 }

    for(i in 1 .. n) {
        arr[i] = st.nextToken().toInt()
    }
    arr = arr.sortedArray()

    visited = Array(n + 1) { false }


    dfs(1, 0, "")
    print(sb.toString())
}

fun dfs(idx: Int, len: Int, str: String) {
    if (len == m) {
        println(str)
        return
    }

    for (i in idx..n) {
        if (i == idx || !visited[i]) {
            visited[i] = true

            if (len == 0)
                dfs(i, 1, arr[i].toString())
            else
                dfs(i, len + 1, "$str ${arr[i]}")

            visited[i] = false
        }
    }
}