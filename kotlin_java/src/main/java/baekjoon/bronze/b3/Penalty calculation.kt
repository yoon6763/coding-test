package baekjoon.bronze.b3

fun main() {
    var max = 0
    var tf = 0
    var sf = 0
    var f = 0

    for (i in 1..readln().toInt()) {
        val (t, s) = readln().split(" ").map { it.toInt() }
        if (s > max) {
            max = s
            f = i
            tf = t
            sf = s
        }
    }

    if (sf == 0) println(0) else println(tf + (f - 1) * 20)
}