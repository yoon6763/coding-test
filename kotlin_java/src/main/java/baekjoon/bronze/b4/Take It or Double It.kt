package baekjoon.bronze.b4

fun main() {
    val (x, d) = readln().split(" ").map { it.toLong() }

    if (2 * x <= d) {
        println("double it")
    } else {
        println("take it")
    }
}
