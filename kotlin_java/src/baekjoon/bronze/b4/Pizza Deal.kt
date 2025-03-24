package baekjoon.bronze.b4

fun main() {
    val (a1, p1) = readln().split(" ").map { it.toDouble() }
    val (a2, p2) = readln().split(" ").map { it.toDouble() }
    if (a1 / p1 < Math.PI * a2 * a2 / p2) println("Whole pizza") else println("Slice of pizza")
}