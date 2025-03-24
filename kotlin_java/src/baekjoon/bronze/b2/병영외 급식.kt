package baekjoon.bronze.b2

fun main() {
    val (n, x) = readln().split(" ").map { it.toInt() }
    print(if(readln().split(" ").sumOf { it.toLong() } % x == 0L) 1 else 0)
}