package baekjoon.bronze.b2

import kotlin.math.sqrt

fun main() {
    var count = 0
    while (true) {
        val str = readln()
        if (str == "0") break

        count++

        val (r, w, l) = str.split(" ").map { it.toInt() }

        if (2 * r >= sqrt((w * w + l * l).toDouble())) {
            println("Pizza $count fits on the table.")
        } else {
            println("Pizza $count does not fit on the table.")
        }
    }
}
