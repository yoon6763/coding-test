package baekjoon.bronze.b4

fun main() {
    val (ca, ba, pa) = readln().split(" ").map { it.toInt() }
    val (cr, br, pr) = readln().split(" ").map { it.toInt() }
    println(maxOf(0, cr - ca) + maxOf(0, br - ba) + maxOf(0, pr - pa))
}