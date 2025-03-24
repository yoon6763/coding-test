package baekjoon.bronze.b2

fun main() = print("%.2f".format(List(readln().toInt()) { readln().toDouble() }.sorted()[1]))