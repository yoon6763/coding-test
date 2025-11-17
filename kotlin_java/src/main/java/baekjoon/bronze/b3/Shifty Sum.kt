package baekjoon.bronze.b3

import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    val power = readln().toInt()
    var ans = 0
    for (i in 0..power) {
        ans += n * 10.0.pow(i.toDouble()).toInt()
    }
    println(ans)
}
