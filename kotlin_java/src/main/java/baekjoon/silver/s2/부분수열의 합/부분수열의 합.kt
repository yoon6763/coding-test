package baekjoon.silver.s2.`부분수열의 합`

lateinit var arr: IntArray
var cnt = 0
var n = 0
var s = 0

fun main() = with(System.`in`.bufferedReader()) {
    val ns = readLine().split(" ").map { it.toInt() }
    arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    n = ns[0]
    s = ns[1]

    backTracking(0, 0)
    println(if (s == 0) cnt - 1 else cnt)
}

fun backTracking(idx: Int, sum: Int) {
    if (idx == n) {
        if (sum == s) cnt++
        return
    }

    backTracking(idx + 1, sum + arr[idx])
    backTracking(idx + 1, sum)
}