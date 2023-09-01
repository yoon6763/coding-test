package baekjoon.silver.s2

import kotlin.math.abs
import kotlin.math.ceil

fun main() {
    var n = readln().toInt()
    val sb = StringBuilder()


    if (n != 0) {
        while (n != 1) {
            sb.append(abs(n % -2))
            n = ceil(n.toDouble() / -2).toInt()
        }
    }
    sb.append(n)

    println(sb.reverse())
}