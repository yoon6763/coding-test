package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    println("${"abcdefgh"[(n - 1) % 8]}${((n + 7) / 8)}")
}