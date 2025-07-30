package baekjoon.bronze.b3

fun main() {
    val n = readln().toDouble()
    println(if (readln().count { it == 'O' }.toDouble() >= n / 2) "Yes" else "No")
}