package baekjoon.bronze.b2

fun main()=print(List(readln().toInt()){readln()}.filter{it.length==3}.sorted()[0])