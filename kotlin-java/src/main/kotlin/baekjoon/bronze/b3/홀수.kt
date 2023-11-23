package baekjoon.bronze.b3

import kotlin.math.min

fun main() {
    var min = Int.MAX_VALUE

    var sum = 0

    repeat(7) {
        val n = readln().toInt()
        if(n % 2 == 1) {
            sum += n
            min = min(min,n)
        }
    }

    if(sum == 0) {
        println(-1)
    } else {
        println("$sum\n$min")
    }
}