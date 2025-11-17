package baekjoon.bronze.b3

fun main()=readln().split(" ").map{it.toInt()}.sorted().let{n->print(if(n[0]+n[1]>n[2])n.sum() else(n[0]+n[1])*2-1)}