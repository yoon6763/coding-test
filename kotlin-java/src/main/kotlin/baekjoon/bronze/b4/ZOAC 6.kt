package baekjoon.bronze.b4

fun main() = print(Array(readln().toInt()) { readln() }.count { "01" in it || "OI" in it })