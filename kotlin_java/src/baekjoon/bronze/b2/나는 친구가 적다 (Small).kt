package baekjoon.bronze.b2

fun main() {
    val line1 = readln().filter { !it.isDigit() }
    val line2 = readln()
    println(if (line1 in line2) 1 else 0)
}