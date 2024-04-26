package baekjoon.bronze.b4

fun main() {
    readln()
    val str = readln()
    println(if(str.all { it == str[0] })"Yes" else "No")
}