package baekjoon.bronze.b2

fun main() = print(readln().groupBy { it }.map { it.value.size }.sorted().let { it.take(maxOf(0, it.size - 2)).sum() })
