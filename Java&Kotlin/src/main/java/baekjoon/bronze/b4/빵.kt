package baekjoon.bronze.b4

import kotlin.math.min

fun main() {
    var min = Int.MAX_VALUE
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if ( a <= b) {
            min = min(min, b)
        }
    }

    println(if(min == Int.MAX_VALUE) -1 else min)
}