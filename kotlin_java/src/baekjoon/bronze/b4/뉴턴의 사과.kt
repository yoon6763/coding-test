package baekjoon.bronze.b4

fun main() {
    val pPos = readln().split(" ").map { it.toInt() }
    val (x, y, r) = readln().split(" ").map { it.toInt() }
    println(if (x in pPos) pPos.indexOf(x) + 1 else 0)
}