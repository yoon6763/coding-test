package baekjoon.bronze.b4

fun main() {
    val (ds, ys) = readln().split(" ").map { it.toInt() }
    val (dm, ym) = readln().split(" ").map { it.toInt() }
    var s = ys - ds
    var m = ym - dm
    while (s != m) if (s < m) s += ys else m += ym
    println(s)
}