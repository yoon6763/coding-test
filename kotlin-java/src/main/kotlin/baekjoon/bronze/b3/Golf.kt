package baekjoon.bronze.b3

fun main() {
    var case = 1
    while (true) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0) break
        println("Hole #${case}")
        when {
            b == 1 -> println("Hole-in-one.")
            a - b == 3 -> println("Double eagle.")
            a - b == 2 -> println("Eagle.")
            a - b == 1 -> println("Birdie.")
            a - b == 0 -> println("Par.")
            a - b == -1 -> println("Bogey.")
            else -> println("Double Bogey.")
        }
        println()
        case++
    }
}
