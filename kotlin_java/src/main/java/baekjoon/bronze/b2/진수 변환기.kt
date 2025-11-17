package baekjoon.bronze.b2

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    println(m.toString(n).uppercase())
}