package baekjoon.bronze.b3

fun main() {
    val (a, b, n) = readln().split(" ").map { it.toInt() }

    for (i in 1..n) {
        print("${a * n + b * i} ")
    }
}