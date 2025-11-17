package baekjoon.bronze.b3

fun main() = print(List(readln().toInt()) { if ("CD" !in readln()) 1 else 0 }.sum())