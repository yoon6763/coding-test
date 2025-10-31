package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val arr = readln().split(' ').map { it.toInt() }
    val diff = arr[n - 1] - arr[n - 2]
    println(arr[n - 1] + diff)
}