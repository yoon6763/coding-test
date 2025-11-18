package baekjoon.bronze.b2

import kotlin.math.abs

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) {
        if (it < n - 1) IntArray(m).apply { this[0] = readln().toInt() } else readln().split(" ").map { it.toInt() }
            .toIntArray()
    }
    for (i in 0..<n) {
        next@ for (j in 0..<m) {
            for (k in 0..<n) if (arr[k][0] != j + abs(i - k)) continue@next
            for (k in 1..<m) if (arr[n - 1][k] != abs(n - 1 - i) + abs(k - j)) continue@next
            println("${i + 1} ${j + 1}")
            return
        }
    }
}
