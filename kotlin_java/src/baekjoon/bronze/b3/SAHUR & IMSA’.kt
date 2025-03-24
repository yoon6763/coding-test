package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (h, m) = readln().split(" ").map { it.toInt() }
    var hour = h
    var minute = m
    if (minute < 45) {
        minute += 15
        hour -= 1
    } else {
        minute -= 45
    }
    if (hour == -1) hour = 23
    println("Case #${it + 1}: $hour $minute")
}