package baekjoon.silver.s4

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val weights = readLine().split(" ").map { it.toInt() }.sorted()

    var l = 0
    var r = n - 1
    var cnt = 0

    while (l < r) {
        val weightSum = weights[l] + weights[r]

        if (weightSum <= k) {
            cnt++
            l++
            r--
        } else {
            r--
        }
    }
    println(cnt)
}