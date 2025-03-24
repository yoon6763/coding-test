package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val (y, t) = List(2) { readln() }
    println((0..<n).count { y[it] == 'C' && t[it] == 'C' })
}