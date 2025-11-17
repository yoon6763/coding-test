package baekjoon.silver.s3

fun main() = repeat(readln().toInt()) {
    val (a, b) = readln().split(" ").map { it.toInt() }

    var allCase = 0
    var winCase = 0

    fun solve(curA: Int, curB: Int, alwaysWinA: Boolean) {
        if (curA > a || curB > b) return
        if (curA == a && curB == b) {
            allCase++
            if (alwaysWinA) winCase++
            return
        }

        solve(curA + 1, curB, curA + 1 > curB && alwaysWinA)
        solve(curA, curB + 1, curA > curB + 1 && alwaysWinA)
    }

    solve(0, 0, true)
    println("Case #${it + 1}: ${winCase.toDouble() / allCase}")
}