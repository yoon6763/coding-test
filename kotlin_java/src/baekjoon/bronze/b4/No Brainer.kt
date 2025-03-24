package baekjoon.bronze.b4

fun main()=repeat(readln().toInt()) {
    val (x,y)=readln().split(" ").map{it.toInt()}
    println(if(x>=y)"MMM BRAINS" else "NO BRAINS")
}