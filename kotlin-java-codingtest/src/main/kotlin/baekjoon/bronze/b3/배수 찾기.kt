package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    while (true) {
        val nn = readln().toInt()
        if (nn == 0) break
        println("$nn is ${if (nn % n == 0) "" else "NOT "}a multiple of $n.")
    }
}