package baekjoon.bronze.b3

fun main()=repeat(readln().toInt()){if(readln().split(" ").mapIndexed {i,v->v.toInt()==i%5+1}.count{it}==10)println(it+1)}