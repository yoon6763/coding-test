package baekjoon.bronze.b3

fun main() {
    val arr = List(readln().toInt()) { readln().split(" ").map { it.toInt() } }
    println((arr.maxOf { it[0] } * arr.minOf { it[1] }) % 7 + 1)
}