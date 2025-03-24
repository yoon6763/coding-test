package baekjoon.bronze.b3

fun main() {
    val (s, a, b) = readln().split(" ").map { it.toInt() }
    val str = readln()
    println("${str.substring(0, a - 1)}${str.substring(a - 1, b).reversed()}${str.substring(b)}")
}