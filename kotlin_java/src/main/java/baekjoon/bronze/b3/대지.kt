package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var top = -10001
    var bottom = 10001
    var left = 10001
    var right = -10001

    repeat(n) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        top = top.coerceAtLeast(y)
        bottom = bottom.coerceAtMost(y)
        left = left.coerceAtMost(x)
        right = right.coerceAtLeast(x)
    }

    println((top - bottom) * (right - left))
}