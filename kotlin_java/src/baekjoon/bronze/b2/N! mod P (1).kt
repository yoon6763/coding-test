package baekjoon.bronze.b2

fun main() {
    val (n, p) = readln().split(" ").map { it.toInt() }
    println((1..n).fold(1L) { acc, i -> (acc * (i % p)) % p })
}