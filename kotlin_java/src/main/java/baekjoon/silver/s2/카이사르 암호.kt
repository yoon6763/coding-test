package baekjoon.silver.s2

fun main()=println(readln().toCharArray().map{if(it in 'D'..'Z') it-3 else it+23}.joinToString(""))
