package baekjoon.bronze.b4

fun main()=print(List(readln().toInt()){ readln().split(" ").map { it.toInt() }.sum() }.minOrNull()!!)