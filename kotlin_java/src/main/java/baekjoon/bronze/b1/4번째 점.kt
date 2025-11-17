package baekjoon.bronze.b1

import java.util.*

fun main() {
    while (true) {
        val line = readlnOrNull() ?: break
        val st = StringTokenizer(line)
        val (x1, y1, x2, y2) = List(4) { st.nextToken().toDouble() }
        val (x3, y3, x4, y4) = List(4) { st.nextToken().toDouble() }

        var x = 0.0
        var y = 0.0

        if (x2 == x3 && y2 == y3) {
            x = x1 + x4 - x2
            y = y1 + y4 - y2
        } else if (x1 == x3 && y1 == y3) {
            x = x2 + x4 - x1
            y = y2 + y4 - y1
        } else if (x1 == x4 && y1 == y4) {
            x = x2 + x3 - x1
            y = y2 + y3 - y1
        } else {
            x = x1 + x3 - x2
            y = y1 + y3 - y2
        }

        println("%.3f %.3f".format(x, y))
    }
}