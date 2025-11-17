package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().trim().split(" ").map { it.toInt() }

    var now = 1
    for (i in 0 until n) {
        if (arr[i] == now) {
            now++
        }
    }

    println(n - now + 1)
}