package baekjoon.bronze.b3

fun main()=repeat(readln().toInt()){println((('A'..'Z').toSet()-readln().toCharArray().toSet()).sumOf{it.toInt()})}