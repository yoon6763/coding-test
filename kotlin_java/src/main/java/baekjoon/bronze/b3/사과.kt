package baekjoon.bronze.b3

fun main()=print(Array(readln().toInt()){val (a,b)=readln().split(" ").map{it.toInt()};b%a}.sum())