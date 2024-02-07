package baekjoon.bronze.b3

fun main() {
    var (l, r, a) = readln().split(' ').map { it.toInt() }

    while (a > 0) {
        if (l < r) l++ else r++
        a--
    }
    println(minOf(l, r) * 2)
}