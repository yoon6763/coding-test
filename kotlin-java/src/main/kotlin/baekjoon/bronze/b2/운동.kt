package baekjoon.bronze.b2

fun main() {
    val (n, m, M, t, r) = readln().split(" ").map { it.toInt() }
    if (m + t > M) {
        println(-1)
        return
    }
    var nowPulse = m
    var totalTime = 0
    var exerciseTime = 0

    while (exerciseTime < n) {
        if (nowPulse + t > M) {
            nowPulse = maxOf(m, nowPulse - r)
        } else {
            exerciseTime++
            nowPulse += t
        }
        totalTime++
    }
    println(totalTime)
}