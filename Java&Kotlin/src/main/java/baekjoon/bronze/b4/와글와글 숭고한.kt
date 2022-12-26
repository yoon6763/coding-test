package baekjoon.bronze.b4

fun main() {
    val n = readln().split(" ").map { it.toInt() }
    if (n.sum() >= 100) println("OK") else {
        when (n.indexOf(n.min())) {
            0 -> println("Soongsil")
            1 -> println("Korea")
            2 -> println("Hanyang")
        }
    }
}