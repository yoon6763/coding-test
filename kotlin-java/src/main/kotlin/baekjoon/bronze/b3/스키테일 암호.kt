package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val str = readln()
    for(i in str.indices step n) print(str[i])
}