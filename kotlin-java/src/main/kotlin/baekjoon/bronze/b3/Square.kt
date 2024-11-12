package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    println((1..readln().toInt()).sumOf { it * it })
}