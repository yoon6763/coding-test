package baekjoon.bronze.b4

import kotlin.math.abs

fun main() {
    readln().toInt()

    var x = 0
    var y = 0

    readln().forEach { direction ->
        when (direction) {
            'E' -> x += 1
            'W' -> x -= 1
            'N' -> y += 1
            'S' -> y -= 1
        }
    }

    println(abs(x) + abs(y))
}
