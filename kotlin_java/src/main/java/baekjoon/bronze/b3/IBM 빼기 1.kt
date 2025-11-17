package baekjoon.bronze.b3

fun main()=repeat(readln().toInt()){
    println("String #${it+1}\n${readln().map {if(it == 'Z')'A' else it+1 }.joinToString("")}\n")
}