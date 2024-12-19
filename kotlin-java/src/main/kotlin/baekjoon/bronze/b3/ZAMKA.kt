package baekjoon.bronze.b3

fun main() {
    val (l, d, x) = List(3) { readln().toInt() }
    var n = Int.MAX_VALUE
    var m = Int.MIN_VALUE

    for (i in l..d) {
        if (i.toString().sumOf { it.digitToInt() } == x) {
            n = minOf(n, i)
            m = maxOf(m, i)
        }
    }

    println(n)
    println(m)
}
