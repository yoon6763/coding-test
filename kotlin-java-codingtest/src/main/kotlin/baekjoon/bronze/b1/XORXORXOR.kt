package baekjoon.bronze.b1

fun main() {
    var (a, b, c) = readln().split(" ").map { it.toInt() }
    if (c % 2 == 1) a = a.xor(b)
    println(a)
}