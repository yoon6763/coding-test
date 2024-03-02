package baekjoon.bronze.b4

fun main() {
    val (y1, m1, d1) = readln().split(" ").map { it.toInt() }
    val (y2, m2, d2) = readln().split(" ").map { it.toInt() }
    val year1 =
        if (m1 < m2) y2 - y1
        else if (m1 == m2 && d1 <= d2) y2 - y1
        else y2 - y1 - 1
    println(year1)
    println(y2 - y1 + 1)
    println(y2 - y1)
}
