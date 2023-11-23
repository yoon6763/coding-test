package baekjoon.bronze.b3

fun main()=repeat(readln().toInt()){println("Case #${it+1}: ${readln().split(" ").maxOf{it.toInt()}}")}