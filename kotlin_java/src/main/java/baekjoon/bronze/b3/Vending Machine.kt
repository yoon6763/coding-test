package baekjoon.bronze.b3

fun main() {
    var sum = 0
    val arr = arrayOf(500, 800, 1000)
    readln().split(" ").forEach { sum += arr[it.toInt() - 1] }
    println(5000 - sum)
}