package baekjoon.bronze.b3

fun main() {
    val n = readln().toDouble()
    val arr = readln().split(" ").map { it.toInt() }
    val (approve, reject, giveUp) = arrayOf(arr.count { it == 1 }, arr.count { it == -1 }, arr.count { it == 0 })

    if (giveUp >= n / 2) println("INVALID")
    else if (approve > reject) println("APPROVED")
    else println("REJECTED")
}