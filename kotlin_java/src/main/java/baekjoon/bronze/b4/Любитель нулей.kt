package baekjoon.bronze.b4

fun main() = print(readln().trim { it == '0' }.count { it == '0' })