package baekjoon.bronze.b4

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val res = arrayOf(a - b, a + b)
    println(res.maxOrNull()!!)
    println(res.minOrNull()!!)
}