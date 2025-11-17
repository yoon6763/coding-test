package baekjoon.bronze.b2

fun main() {
    val (h1, m1, s1) = readln().split(":").map { it.toInt() }
    val (h2, m2, s2) = readln().split(":").map { it.toInt() }

    val t1 = h1 * 3600 + m1 * 60 + s1
    val t2 = h2 * 3600 + m2 * 60 + s2

    val t = if (t2 < t1) t2 + 24 * 3600 else t2
    var diff = t - t1

    val h = diff / 3600
    diff %= 3600
    val m = diff / 60
    diff %= 60
    val s = diff

    println("%02d:%02d:%02d".format(h, m, s))
}