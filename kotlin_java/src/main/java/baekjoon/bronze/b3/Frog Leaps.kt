package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val x = LongArray(n) { readln().toLong() }
    var answer = 0L

    for (i in 0 until n - 1) {
        val diff = x[i + 1] - x[i]
        answer += diff * diff
    }

    println(answer)
}