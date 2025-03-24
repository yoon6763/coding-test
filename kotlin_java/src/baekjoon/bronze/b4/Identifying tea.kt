package baekjoon.bronze.b4

fun main()=println(readln().let{n->readln().split(" ").count {n==it}})