package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val bus = readln().split(" ").map { it.toInt() - 1 }
    val cost = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    var total = 0
    for (i in 0 until m - 1) {
        total += cost[bus[i]][bus[i + 1]]
    }

    println(total)
}
