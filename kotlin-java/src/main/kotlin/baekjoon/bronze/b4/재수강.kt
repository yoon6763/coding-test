package baekjoon.bronze.b4

fun main() =
    print(readln().substring(0, 5).let { t -> List(readln().toInt()) { readln().substring(0, 5) }.count { it == t } })