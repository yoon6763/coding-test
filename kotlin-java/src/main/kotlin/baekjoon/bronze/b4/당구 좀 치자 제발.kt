package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val fury = Array(n) { 0 }
    var tmp = 0

    repeat(n) {
        tmp += if (arr[it] == 1) 1 else -1
        fury[it] = tmp
    }

    println(fury.sum())
}