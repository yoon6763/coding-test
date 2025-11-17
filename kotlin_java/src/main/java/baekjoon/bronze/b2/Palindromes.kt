package baekjoon.bronze.b2

fun main() {
    readln()
    println(readln().split(" ").filter { it==it.reversed() }.sumOf { it.toLong() })
}