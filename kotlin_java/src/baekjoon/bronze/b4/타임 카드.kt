package baekjoon.bronze.b4

fun main() = repeat(3) {
    val times = readln().split(" ").map { it.toInt() }
    val second = times[3] * 3600 + times[4] * 60 + times[5] - times[0] * 3600 - times[1] * 60 - times[2]
    println("${second / 3600} ${second % 3600 / 60} ${second % 60}")
}