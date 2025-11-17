package baekjoon.silver.s4.`Bookshelf 2`

import kotlin.math.min

var n = 0
var m = 0
var ans = Int.MAX_VALUE
lateinit var arr: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    arr = IntArray(n) { readLine().toInt() }
    solve(0, 0)
    println(ans)
}

fun solve(cur: Int, sum: Int) {
    if (sum >= m) {
        ans = min(ans, sum - m)
        return
    }

    for (i in cur..<n) solve(i + 1, sum + arr[i])
}
