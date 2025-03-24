package baekjoon.silver.s4

import kotlin.math.pow

fun main() {
    val n = readln()
    var result = 0
    for (i in 1..<n.length) {
        result += 9 * 10.0.pow(i - 1).toInt() * i
    }
    println(result + (n.toInt() - 10.0.pow(n.length - 1).toInt() + 1) * n.length)
}
