package baekjoon.bronze.b3

fun main() {
    readln()
    val arr = readln().split(" ").map { it.toInt() }
    println(arr.indexOf(arr.minOrNull()))
}