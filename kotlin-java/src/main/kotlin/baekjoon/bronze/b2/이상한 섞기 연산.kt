package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    println(if (readln().toInt() <= 2) 1 else 3)
}