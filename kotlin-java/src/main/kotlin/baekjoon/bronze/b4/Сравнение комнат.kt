package baekjoon.bronze.b4

fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    val (t1, t2) = a * b to c * d
    println(if (t1 > t2) "M" else if (t1 < t2) "P" else "E")
}