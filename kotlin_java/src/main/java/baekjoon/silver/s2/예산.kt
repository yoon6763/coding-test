package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }

    var left = 1
    var right = arr.max()

    val m = readLine().toInt()

    while (left <= right) {
        val mid = (left + right) / 2
        var sum = 0L

        for (i in 0..<n) {
            sum += if (arr[i] > mid) mid else arr[i]
        }

        if (sum <= m) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(right)
}
