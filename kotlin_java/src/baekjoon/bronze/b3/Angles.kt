package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val arr = readln().split(" ").map { it.toInt() }
    println("${arr.joinToString(" ")} ${if (arr.sum() == 180) "Seems OK" else "Check"}")
}