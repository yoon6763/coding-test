package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    println("Case #${it + 1}: ${readln().split(" ").reversed().joinToString(" ")}")
}