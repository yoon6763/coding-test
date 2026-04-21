package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    if (m * 100 >= n * 81) {
        println("yaho")
    } else {
        println("no")
    }
}