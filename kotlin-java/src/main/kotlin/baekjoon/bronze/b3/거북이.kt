package baekjoon.bronze.b3

fun main() {
    val arr = readln().split(" ").map { it.toInt() }.sorted()
    println(arr[0] * arr[2])
}