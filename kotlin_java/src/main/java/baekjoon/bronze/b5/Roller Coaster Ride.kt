package baekjoon.bronze.b5

fun main() {
    val N = readln().toInt()
    val C = readln().toInt()
    val P = readln().toInt()
    if (N <= C * P) println("yes") else println("no")
}