package baekjoon.bronze.b3

fun main() {
    readln()
    println((readln().split(" ").toSet() - readln().split(" ").toSet()).joinToString())
}