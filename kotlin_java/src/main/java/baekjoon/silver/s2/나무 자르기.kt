package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ")

    val n = nm[0].toInt()
    val m = nm[1].toLong()

    val arr = readLine().split(" ").map { it.toInt() }

    var left = 0L
    var right = Long.MAX_VALUE

    while (left <= right) {
        val mid = (left + right) / 2
        var sum = 0L

        for (i in 0..<n) {
            sum += maxOf(0, arr[i] - mid)
        }

        if (sum >= m) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(right)
}