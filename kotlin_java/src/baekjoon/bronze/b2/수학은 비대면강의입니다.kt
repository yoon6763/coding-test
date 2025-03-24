package baekjoon.bronze.b2

import java.util.StringTokenizer

fun main() {
    val line = StringTokenizer(readln())
    val (a, b, c) = Array(3) { line.nextToken().toInt() }
    val (d, e, f) = Array(3) { line.nextToken().toInt() }

    for (x in -999..999) {
        for (y in -999..999) {
            if (a * x + b * y == c && d * x + e * y == f) return println("$x $y")
        }
    }
}