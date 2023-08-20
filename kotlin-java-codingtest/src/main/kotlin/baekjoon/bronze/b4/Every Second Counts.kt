package baekjoon.bronze.b4

fun main() {
    val (h1, m1, s1) = readln().split(" : ").map(String::toInt)
    val (h2, m2, s2) = readln().split(" : ").map(String::toInt)

    var time1 = h1 * 3600 + m1 * 60 + s1
    var time2 = h2 * 3600 + m2 * 60 + s2

    if (time2 < time1) time2 += 24 * 3600

    println("${time2 - time1}")
}