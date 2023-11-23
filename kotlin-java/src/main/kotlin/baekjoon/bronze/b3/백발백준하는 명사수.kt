package baekjoon.bronze.b3

fun main() {
    val (x1, y1, r1) = readln().split(" ").map { it.toBigDecimal() }
    val (x2, y2, r2) = readln().split(" ").map { it.toBigDecimal() }
    if ((x1 - x2).pow(2) + (y1 - y2).pow(2) >= (r1 + r2).pow(2)) println("NO") else println("YES")
}