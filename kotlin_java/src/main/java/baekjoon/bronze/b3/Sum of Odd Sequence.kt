package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    println(List(readln().toInt() + 1) { it }.filterIndexed { _, i -> i % 2 == 1 }.sum())
}