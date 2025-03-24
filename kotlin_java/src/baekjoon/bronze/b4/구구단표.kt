package baekjoon.bronze.b4

fun main() = print(if (readln().toInt() in (1..9).flatMap { i -> (1..9).map { j -> i * j } }) 1 else 0)