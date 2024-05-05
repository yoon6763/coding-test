package baekjoon.bronze.b4

fun main() {
    val (p1, q1, p2, q2) = readln().split(" ").map { it.toDouble() }
    println(if ((p1 * p2) % (q1 * q2 * 2) == 0.0) "1" else "0")
}
