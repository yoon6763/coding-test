package baekjoon.bronze.b3

fun main() {
    val str = readln().toSet()
    println(readln().filterNot { it in str })
}