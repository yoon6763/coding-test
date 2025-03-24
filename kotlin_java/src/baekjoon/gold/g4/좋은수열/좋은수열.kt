package baekjoon.gold.g4.`좋은수열`

import kotlin.system.exitProcess

lateinit var arr: IntArray
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = IntArray(n)
    solve(0)
}

fun solve(index: Int) {
    if (index > 0 && !valid(index)) return

    if (index == n) {
        println(arr.joinToString(""))
        exitProcess(0)
    }

    for (i in 1..3) {
        val pre = if (index == 0) 0 else arr[index - 1]
        if (i == pre) continue
        arr[index] = i
        solve(index + 1)
    }
}

fun valid(curLength: Int): Boolean {
    for (length in 1..curLength / 2) {
        for (start in 0..<curLength - length * 2 + 1) {
            val startA = start
            val startB = start + length

            var a = 0L
            var b = 0L

            var index = 1

            for (i in 0..<length) {
                a += arr[startA + i] * index
                b += arr[startB + i] * index
                index *= 10
            }
            if (a == b) return false
        }
    }

    return true
}