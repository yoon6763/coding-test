package baekjoon.bronze.b4

fun main() {
    val square = readln().split(" ").map { it.toLong() }.toLongArray()
    println(if (square[0] % 2 == 0L || square[1] % 2 == 0L) 0 else square.min())
}