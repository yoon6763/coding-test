package baekjoon.bronze.b3

fun main() {
    readln()
    println(readln().split(" ").map { it.toLong() }.maxOrNull()!! + readln().split(" ").map { it.toLong() }.maxOrNull()!!)
}