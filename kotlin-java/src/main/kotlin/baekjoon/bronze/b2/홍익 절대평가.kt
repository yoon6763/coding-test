package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val (x, y) = readln().split(" ").map { it.toInt() }

    var cnt = 0
    repeat(n) {
        if (arr[it] >= y) cnt++
    }
    println("${n * x / 100} ${cnt}")
}