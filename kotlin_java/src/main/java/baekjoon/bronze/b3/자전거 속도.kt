package baekjoon.bronze.b3

import java.util.*

fun main() {
    var idx = 1
    while (true) {
        val st = StringTokenizer(readln())
        var (A, B, C) = List(3) { st.nextToken().toDouble() }
        if (B == 0.0) break
        C = (C / 60) / 60
        val distance = ((((A * 3.1415927) * B) / 12) / 5280)
        println("Trip #$idx: ${String.format("%.2f", distance)} ${String.format("%.2f", distance / C)}")
        idx++
    }
}
