package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    println((readln().split(" ").sumOf { it.reversed().toInt() }).toString().reversed().toInt())
}