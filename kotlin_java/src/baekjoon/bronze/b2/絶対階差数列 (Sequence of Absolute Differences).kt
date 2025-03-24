package baekjoon.bronze.b2

import kotlin.math.absoluteValue

fun main() {
    var n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()

    repeat(n - 1) {
        for (i in 0..<n - 1) arr[i] = (arr[i] - arr[i + 1]).absoluteValue
        n--
    }

    println(arr[0])
}