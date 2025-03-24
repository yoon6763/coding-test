package baekjoon.bronze.b3

fun main() {
    val t1 = readln().split(":").map { it.toInt() }
    val t2 = readln().split(":").map { it.toInt() }
    val t1Sec = t1[0] * 3600 + t1[1] * 60 + t1[2]
    var t2Sec = t2[0] * 3600 + t2[1] * 60 + t2[2]
    if (t2Sec <= t1Sec) t2Sec += 24 * 3600
    var diff = t2Sec - t1Sec
    val h = diff / 3600
    diff %= 3600
    val m = diff / 60
    val s = diff % 60
    println("%02d:%02d:%02d".format(h, m, s))
}