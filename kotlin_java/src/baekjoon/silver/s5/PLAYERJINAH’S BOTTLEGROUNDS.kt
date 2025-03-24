package baekjoon.silver.s5

fun main() {
    val (x1, y1) = readln().split(" ").map { it.toDouble() }
    val (x2, y2) = readln().split(" ").map { it.toDouble() }
    val (x3, y3) = readln().split(" ").map { it.toDouble() }

    if ((x1 - x2) / (y1 - y2) == (x2 - x3) / (y2 - y3)) println("WHERE IS MY CHICKEN?")
    else println("WINNER WINNER CHICKEN DINNER!")
}