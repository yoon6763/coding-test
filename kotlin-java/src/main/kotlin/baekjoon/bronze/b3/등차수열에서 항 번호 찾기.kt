package baekjoon.bronze.b3

fun main() {
    var (a, d, k) = readln().split(" ").map { it.toInt() }
    k -= a
    if(k % d != 0 || k / d < 0) println("X")
    else println(k / d + 1)
}