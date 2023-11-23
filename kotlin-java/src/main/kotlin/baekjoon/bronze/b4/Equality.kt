package baekjoon.bronze.b4

fun main() {
    val input = readln().split(" ")
    println(if (input[0].toInt() + input[2].toInt() == input[4].toInt()) "YES" else "NO")
}