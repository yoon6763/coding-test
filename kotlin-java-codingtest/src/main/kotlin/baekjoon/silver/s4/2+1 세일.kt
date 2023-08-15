package baekjoon.silver.s4

fun main()=print(Array(readln().toInt()){readln().toInt()}.sortedDescending().filterIndexed {i,_->i%3!=2}.sum())