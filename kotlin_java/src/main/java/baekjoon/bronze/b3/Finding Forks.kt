package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toLong() }.sorted()
    println(arr[0] + arr[1])
}