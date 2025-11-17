package baekjoon.bronze.b2

fun main() = print(List(readln().toInt()){readln().split(" ")}.sortedBy {it[1]}[0][0])
