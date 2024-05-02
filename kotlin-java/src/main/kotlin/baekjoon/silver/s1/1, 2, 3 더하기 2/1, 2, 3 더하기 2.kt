package baekjoon.silver.s1.`1, 2, 3 더하기 2`

import java.util.*
import kotlin.system.exitProcess

lateinit var arr: IntArray
var count = 0
var n = 0
var k = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    k = st.nextToken().toInt()
    arr = IntArray(n)

    solve(0, 0)
    println(-1)
}

fun solve(index: Int, sum: Int) {
    if (sum == n) {
        count++
        if (count == k) {
            val sb = StringBuilder()
            for (i in 0 until index) {
                sb.append(arr[i])
                if(i < index -1) {
                    sb.append("+")
                }
            }
            println(sb.toString())
            exitProcess(0)
        }
        return
    }

    for (i in 1..3) {
        if (sum + i > n) break
        arr[index] = i
        solve(index + 1, sum + i)
    }
}