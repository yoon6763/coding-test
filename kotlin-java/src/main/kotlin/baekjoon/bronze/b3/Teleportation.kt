package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val (s, e, t1, t2) = readln().split(" ").map { it.toInt() }
    val (start, end) = if (s < e) s to e else e to s
    val (teleport1, teleport2) = if (t1 < t2) t1 to t2 else t2 to t1
    println(minOf((end - start), abs(end - teleport2) + abs(teleport1 - start)))
}