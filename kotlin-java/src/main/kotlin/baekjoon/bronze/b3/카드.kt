package baekjoon.bronze.b3

fun main() {
    readln()
    println(readln().split(" ").map { it.toInt() }.sorted().dropLast(1).sum())
}