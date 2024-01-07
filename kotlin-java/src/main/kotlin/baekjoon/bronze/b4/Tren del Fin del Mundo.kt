package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val points = List(n) { readln().split(" ").map { it.toInt() } }.sortedBy { it[1] }
    println("${points[0][0]} ${points[0][1]}")
}