package baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine(), " ")

    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    val arr2 = arr.sorted()

    var idx = 0
    val map = HashMap<Int,Int>()

    for(i in 0 until n) {
        if(!map.contains(arr2[i])) {
            map[arr2[i]] = idx++
        }
    }

    val sb = StringBuilder()


    for(i in 0 until n) {
        sb.append(map[arr[i]]).append(" ")
    }
    println(sb.toString())
}