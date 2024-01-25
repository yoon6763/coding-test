package baekjoon.bronze.b5

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    if (arr[0] >= arr[1] - arr[0]) println("E") else println("H")
}