package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    println(if (readln().last().digitToInt() % 2 == 0) "even" else "odd")
}