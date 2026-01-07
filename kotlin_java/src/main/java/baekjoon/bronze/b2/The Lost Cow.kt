package baekjoon.bronze.b2

import kotlin.math.*

fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    var cur = x
    var distance = 0
    var step = 1
    var flag = 1

    while (true) {
        val target = x + flag * step

        if ((y in cur..target) || (y in target..cur)) {
            distance += abs(cur - y)
            break
        } else {
            distance += abs(cur - target)
            cur = target
        }

        step *= 2
        flag = -flag
    }

    println(distance)
}