package baekjoon.bronze.b2

fun main()=repeat(2){print("${List(10){readln().toInt()}.sortedDescending().subList(0, 3).sum()} ")}