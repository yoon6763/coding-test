package baekjoon.silver.s5

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val arr = Array(n) { intArrayOf(0, 0, 0) }
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        arr[it][0] = st.nextToken().toInt()
        arr[it][1] = st.nextToken().toInt()
        arr[it][2] = st.nextToken().toInt()
    }

    arr.sortByDescending { it[2] }

    val cntForCountries = Array(n + 1) { 0 }
    var cnt = 0
    arr.forEach {
        if (cnt == 3) return
        if (cntForCountries[it[0]] < 2) {
            println("${it[0]} ${it[1]}")
            cntForCountries[it[0]]++
            cnt++
        }
    }
}