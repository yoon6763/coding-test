package baekjoon.bronze.b3

import java.util.*

fun main() {
    val (h, m, s) = readln().split(" ").map { it.toInt() }
    var sec = h * 3600 + m * 60 + s

    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        when (st.nextToken().toInt()) {
            1 -> sec = (sec + st.nextToken().toInt()) % 86400

            2 -> {
                sec = (sec - st.nextToken().toInt()) % 86400
                if (sec < 0) sec += 24 * 3600
            }

            3 -> println("${sec / 3600} ${sec / 60 % 60} ${sec % 60}")
        }
    }
}
