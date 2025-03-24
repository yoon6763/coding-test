package baekjoon.bronze.b3

fun main()=print(List(readln().toInt()){(it+1)%(it+1).toString().sumOf{it.digitToInt()}}.count{it==0})