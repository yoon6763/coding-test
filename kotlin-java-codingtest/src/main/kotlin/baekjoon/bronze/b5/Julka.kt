package baekjoon.bronze.b5

fun main() {
    val (s, n) = Array(2) { readln().toBigInteger() }
    println((s - n) / 2.toBigInteger() + n)
    println((s - n) / 2.toBigInteger())
}