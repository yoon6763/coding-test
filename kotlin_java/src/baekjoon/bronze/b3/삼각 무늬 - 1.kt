package baekjoon.bronze.b3


fun main() = repeat(readln().toInt()) {
    val (a, b) = readln().split(" ").map { it.toInt() }
    if (a % b == 0) println((a / b) * (a / b))
    else println(((a / b) + 1) * ((a / b) + 1))
}
