package baekjoon.bronze.b4

fun main() {
    readln()
    val arr = readln().split(" ").map { it.toInt() }
    val time = arr.sum() + (arr.size - 1) * 8
    println("${time / 24} ${time % 24}")
}