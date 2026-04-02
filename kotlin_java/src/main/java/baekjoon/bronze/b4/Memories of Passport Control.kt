package baekjoon.bronze.b4

fun main() {
    val (k, s) = readln().split(" ").map { it.toInt() }
    println(s / k + s % k)
}