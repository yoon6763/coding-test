package baekjoon.bronze.b1

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        val arr = Array(n) { readln() }.sortedBy { it.lowercase() }
        println(arr[0])
    }
}