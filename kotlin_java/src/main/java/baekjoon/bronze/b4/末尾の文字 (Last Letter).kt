package baekjoon.bronze.b4

fun main() {
    readln()
    val str = readln()
    if(str.last() == 'G') println(str.substring(0,str.length-1)) else println(str+"G")
}