package baekjoon.bronze.b3

import kotlin.system.exitProcess

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    var d = 1
    var cnt = 0

    while (d <= n) {
        if (n % d == 0) {
            cnt++
        }
        if (cnt == k) {
            println(d)
            exitProcess(0)
        }
        d++
    }
    println(0)
}