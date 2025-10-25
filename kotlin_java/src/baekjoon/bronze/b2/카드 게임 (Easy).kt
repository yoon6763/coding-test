package baekjoon.bronze.b2

fun main() {
    val (n, h) = readln().split(" ").map { it.toInt() }
    val cards = readln().split(" ").map { it.toInt() }

    var total = 0
    for (i in 0 until n) {
        total += cards[i]
        if (total < h) continue
        println(i + 1)
        return
    }
    println(-1)
}
