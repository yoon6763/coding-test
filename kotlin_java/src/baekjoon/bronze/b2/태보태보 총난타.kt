package baekjoon.bronze.b2

fun main()=print(readln().split("(^0^)").map { it.count { it == '@' } }.joinToString(" "))