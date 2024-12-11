package baekjoon.bronze.b3

fun main() {
    val m = readln().split(" ").map { it.toInt() }.last()

    println(readln().split(" ").map { it.toInt() }
        .runningFold(0) { acc, it -> maxOf(0, acc + it) }
        .count { it >= m })
}
