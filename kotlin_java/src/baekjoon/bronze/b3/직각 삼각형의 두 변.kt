package baekjoon.bronze.b3

import java.util.*
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    var idx = 1

    while (true) {
        val st = StringTokenizer(readLine())
        var (a, b, c) = List(3) { st.nextToken().toDouble() }

        if (a == 0.0 && b == 0.0 && c == 0.0) break

        println("Triangle #$idx")

        if (a == -1.0) {
            if (c <= b) {
                println("Impossible.")
            } else {
                a = sqrt((c * c) - (b * b))
                println("a = " + String.format("%.3f", a))
            }
        }
        if (b == -1.0) {
            if (c <= a) {
                println("Impossible.")
            } else {
                b = sqrt((c * c) - (a * a))
                println("b = " + String.format("%.3f", b))
            }
        }
        if (c == -1.0) {
            c = sqrt((a * a) + (b * b))
            println("c = " + String.format("%.3f", c))
        }
        idx++
        println()
    }
}