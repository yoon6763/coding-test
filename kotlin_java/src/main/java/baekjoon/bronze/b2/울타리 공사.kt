package baekjoon.bronze.b2

import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    var (a, b, c, d) = readln().split(" ").map { it.toInt() }
    val calc = { x1: Int, y1: Int, x2: Int, y2: Int -> ((x2 - x1) + (y2 - y1)) * 2 }
    println(calc(a, b, c, d))

    repeat(n - 1) {
        val (newA, newB, newC, newD) = readln().split(" ").map { it.toInt() }
        a = min(a, newA)
        b = min(b, newB)
        c = max(c, newC)
        d = max(d, newD)
        println(calc(a, b, c, d))
    }
}