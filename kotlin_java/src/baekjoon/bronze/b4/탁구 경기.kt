package baekjoon.bronze.b4

import kotlin.math.abs

fun main() {
    var (d, p) = 0 to 0
    for (i in 0..<readln().toInt()) {
        if (readln() == "D") d++ else p++
        if (abs(d - p) > 1) break
    }
    println("$d:$p")
}