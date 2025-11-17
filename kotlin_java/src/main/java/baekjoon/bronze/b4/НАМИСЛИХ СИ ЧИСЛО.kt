package baekjoon.bronze.b4

fun main() {
    var (a, b) = readln().split(" ").map { it.toLong() }
    b += a
    b *= a
    b += a
    b *= a
    println(b)
}