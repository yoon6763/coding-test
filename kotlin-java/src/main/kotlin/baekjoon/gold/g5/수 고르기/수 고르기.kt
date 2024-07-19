package baekjoon.gold.g5.`수 고르기`

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().toLong() }.sorted()

    var left = 0
    var right = 1

    var min = Long.MAX_VALUE

    while (right in left..<n) {
        val diff = arr[right] - arr[left]

        if (diff < m) {
            right++
        } else {
            min = min.coerceAtMost(diff)
            left++
        }
    }

    println(min)
}