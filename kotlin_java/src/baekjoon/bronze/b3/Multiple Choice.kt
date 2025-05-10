package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val ans = List(n) { readln() }
    val input = List(n) { readln() }

    var count = 0
    for (i in 0 until n) {
        if (ans[i] == input[i]) count++
    }

    println(count)
}