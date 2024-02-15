package baekjoon.bronze.b3

fun main() {
    readln()
    println(readln().split(" ").maxOf { it.toInt() })
}