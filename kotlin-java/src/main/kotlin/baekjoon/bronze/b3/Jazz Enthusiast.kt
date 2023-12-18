package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var second = m

    repeat(n) {
        val (min, sec) = readln().split(":").map { it.toInt() }
        second += min * 60 + sec - m
    }
    var min = second / 60
    second %= 60

    var hour = min / 60
    min %= 60

    println("%02d:%02d:%02d".format(hour, min, second))
}