package baekjoon.bronze.b1

fun main() {
    readln()
    println(
        readln()
            .split('.', '|', ':', '#')
            .sumOf { it.toInt() })
}