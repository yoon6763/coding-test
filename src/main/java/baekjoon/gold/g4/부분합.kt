package baekjoon.gold.g4

import kotlin.math.min

fun main() {
    val ns = readLine()!!.split(" ")
    val n = ns[0].toInt()
    val s = ns[1].toInt()

    val arr = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()

    var left = 0
    var right = 0
    var sum = 0
    var min = Int.MAX_VALUE

    while (true) {
        if (sum >= s) {
            min = min(min, right - left)
            sum -= arr[left++]
        } else if (n == right) break
        else {
            sum += arr[right++]
        }
    }

    if (min == Int.MAX_VALUE) println(0) else println(min)
}

/*
10 15
5 1 3 5 10 7 4 9 2 8

2
 */