package baekjoon.bronze.b3

import kotlin.math.pow

fun main() {
    next@ while (true) {
        val (b, n) = readln().split(" ").map { it.toInt() }
        if (b == 0 && n == 0) break

        var a = 0.0
        while (true) {
            if (a.pow(n).toInt() >= b) {
                val diff1 = a.pow(n).toInt() - b
                val diff2 = b - a.minus(1).pow(n).toInt()
                println(if (diff1 <= diff2) a.toInt() else a.minus(1).toInt())
                continue@next
            }
            a++
        }
    }
}

