package baekjoon.silver.s5

fun main() {
    val (a1, a0) = readln().split(" ").map { it.toInt() }
    val c = readln().toInt()
    val n0 = readln().toInt()

    if ((a1 * n0 + a0 <= c * n0) && (a1 <= c)) {
        println(1)
    } else {
        println(0)
    }
}