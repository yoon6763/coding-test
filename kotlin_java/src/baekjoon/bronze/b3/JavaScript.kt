package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ")
    try {
        println(n.toInt() - m.toInt())
    } catch (e: Exception) {
        println("NaN")
    }
}