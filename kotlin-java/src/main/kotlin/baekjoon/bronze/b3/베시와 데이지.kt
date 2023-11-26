package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val (bx, by) = readln().split(" ").map(String::toInt)
    val (dx, dy) = readln().split(" ").map(String::toInt)
    val (jx, jy) = readln().split(" ").map(String::toInt)

    val b = maxOf(abs(bx - jx), abs(by - jy))
    val d = abs(dx - jx) + abs(dy - jy)

    when {
        b < d -> println("bessie")
        b > d -> println("daisy")
        else -> println("tie")
    }
}