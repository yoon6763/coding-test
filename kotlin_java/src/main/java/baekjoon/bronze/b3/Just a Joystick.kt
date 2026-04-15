package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val from = readln()
    val to = readln()

    var answer = 0

    for (i in 0 until n) {
        val diff = kotlin.math.abs(from[i] - to[i])
        answer += minOf(diff, 26 - diff)
    }

    println(answer)
}