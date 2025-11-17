package baekjoon.silver.s5

fun main() {
    val n = readLine()!!.toInt()
    var maxIdx = -1
    var maxLen = -1

    for (i in 1..n) {
        val len = solve(n, i, false)
        if (len > maxLen) {
            maxLen = len
            maxIdx = i
        }
    }

    println(maxLen)
    solve(n, maxIdx, true)
}

fun solve(n: Int, i: Int, isPrint: Boolean): Int {
    var prev = n
    var now = i

    if (isPrint) print("$prev $now ")

    var len = 2
    while (prev - now >= 0) {
        val tmp = prev - now
        prev = now
        now = tmp
        if(isPrint) print("$now ")
        len++
    }
    return len
}