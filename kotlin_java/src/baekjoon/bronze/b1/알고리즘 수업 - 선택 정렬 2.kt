package baekjoon.bronze.b1

import java.util.*

fun main() {
    var st = StringTokenizer(readln())
    val sb = StringBuilder()
    val (n, k) = listOf(st.nextToken().toInt(), st.nextToken().toInt())
    var cnt = 0
    st = StringTokenizer(readln())

    val arr = IntArray(n) { st.nextToken().toInt() }

    for (i in n - 1 downTo 0) {
        var max = 0
        var idx = 0
        for (j in 0..<i) {
            if (max < arr[j]) {
                max = arr[j]
                idx = j
            }
        }
        if (arr[i] < arr[idx]) {
            val temp = arr[i]
            arr[i] = arr[idx]
            arr[idx] = temp
            cnt++
        }
        if (cnt == k) break
    }
    if (cnt < k) println(-1)
    else {
        for (i in 0..<n) sb.append(arr[i]).append(" ")
        println(sb)
    }
}