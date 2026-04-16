package baekjoon.bronze.b3

fun main() {
    val input = readln()
    val (mm, ss) = input.split(":").map { it.toInt() }

    val intended = mm * 60 + ss
    val actual = mm * 3600 + ss * 60

    var diff = actual - intended

    val h = diff / 3600
    diff %= 3600
    val m = diff / 60
    val s = diff % 60

    println("%02d:%02d:%02d".format(h, m, s))
}