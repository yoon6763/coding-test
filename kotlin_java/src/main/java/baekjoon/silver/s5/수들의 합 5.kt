package baekjoon.silver.s5

fun main() {
    val n = readln().toInt()

    var left = 1
    var right = 1

    var sum = 1
    var count = 0

    while (left <= n && right <= n) {
        if (sum == n) {
            count++
            sum -= left
            left++
        } else if (sum < n) {
            right++
            sum += right
        } else {
            sum -= left
            left++
        }
    }

    println(count)
}