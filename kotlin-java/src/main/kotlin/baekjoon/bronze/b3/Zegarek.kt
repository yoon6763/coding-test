package baekjoon.bronze.b3

fun main() {
    var (h, m, s) = readln().split(" ").map { it.toInt() }
    s++
    if (s == 60) {
        s = 0
        m++
    }
    if (m == 60) {
        m = 0
        h++
    }
    if (h == 24) h = 0

    println("%02d:%02d:%02d".format(h, m, s))
}