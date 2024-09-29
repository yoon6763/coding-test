package baekjoon.bronze.b3

import kotlin.math.sqrt

fun main() {
    while (true) {
        val (d, rh, rv) = readln().split(" ").map { it.toDouble() }
        if (d == 0.0 && rh == 0.0 && rv == 0.0) break

        val w = 16 * d / sqrt(337.0)
        val h = 9 * w / 16

        println("Horizontal DPI: %.2f".format(rh / w))
        println("Vertical DPI: %.2f".format(rv / h))
    }
}
